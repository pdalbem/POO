package model;

import java.time.LocalDate;

public class Doacao {
    private final int id;
    private final LocalDate dataDoacao;
    private final Doador doador;

    // doacao criada a partir do BD, já tem id
    public Doacao(int id, LocalDate dataDoacao, Doador doador) {
        if (dataDoacao == null)
            throw new IllegalArgumentException("Data não pode ser nula");
        if (doador == null)
            throw new IllegalArgumentException("Doador não pode ser nulo");

        this.id = id;
        this.dataDoacao = dataDoacao;
        this.doador = doador;
    }

    // doacao criada  pelo usuario
    public Doacao(LocalDate dataDoacao, Doador doador) {
        this(0, dataDoacao, doador);
    }

    @Override
    public String toString() {
        return "Doacao{" +
                "id=" + id +
                ", dataDoacao=" + dataDoacao +
                ", doador=" + doador.getNome() +
                '}';
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataDoacao() {
        return dataDoacao;
    }

    public Doador getDoador() {
        return doador;
    }
}
