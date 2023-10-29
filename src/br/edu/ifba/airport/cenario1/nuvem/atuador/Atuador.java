package br.edu.ifba.airport.cenario1.nuvem.atuador;

import java.util.List;

public interface Atuador<Leitura, Resultado> {

    Resultado atuar(List<Leitura> leituras);

}
