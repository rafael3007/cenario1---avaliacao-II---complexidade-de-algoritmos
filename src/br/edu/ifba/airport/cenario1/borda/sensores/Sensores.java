package br.edu.ifba.airport.cenario1.borda.sensores;

public interface Sensores<Leitura> {

    public boolean temLeitura();

    public Leitura getLeitura();

}
