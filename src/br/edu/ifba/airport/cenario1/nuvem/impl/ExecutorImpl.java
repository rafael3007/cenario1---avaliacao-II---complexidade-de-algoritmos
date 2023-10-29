package br.edu.ifba.airport.cenario1.nuvem.impl;

// import java.util.List;

import br.edu.ifba.airport.cenario1.borda.impl.SensoresImpl;
import br.edu.ifba.airport.cenario1.modelo.Aeroporto;
import br.edu.ifba.airport.cenario1.modelo.Trafego;
import br.edu.ifba.airport.cenario1.nuvem.executor.Executor;

public class ExecutorImpl extends Executor {

    private Aeroporto aeroporto = null;
    private SensoresImpl sensores = null;

    AtuadorImpl banco = new AtuadorImpl(); // atenção aqui

    public ExecutorImpl(
            Aeroporto aeroporto, SensoresImpl sensores,
            int totalDeLeituras) {
        super(totalDeLeituras);

        this.aeroporto = aeroporto;
        this.sensores = sensores;

    }

    // constante, O(1)
    @Override
    public void processarLeitura(int leituraAtual) {
        if (sensores.temLeitura()) {
            Trafego leitura = sensores.getLeitura();
            aeroporto.onLeitura(leitura);

            // atenção aqui
            String informacoes = banco.atuar(aeroporto.getLeituras());
            informacoes = informacoes == "" ? "nenhum problema encontrado, " : informacoes;

            System.out
                    .println("leitura realizado no ciclo #" + leituraAtual + " para o Aeroporto " + aeroporto.getNome()
                            + ":" + informacoes);
        }
    }

}
