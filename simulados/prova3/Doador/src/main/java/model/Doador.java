package model;

import java.time.LocalDate;

public class Doador {
    private final int id;
    private final String nome;
    private final String cpf;
    private final LocalDate dataNascimento;
    private final Sexo sexo;
    private final TipoSanguineo tipoSanguineo;
    private double peso;
    private LocalDate dataUltimaDoacao;


    public void validarDados(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, TipoSanguineo tipoSanguineo){
        if (nome==null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo");
        if (cpf==null || cpf.isBlank())
            throw new IllegalArgumentException("CPF não pode ser nulo");
        if (dataNascimento==null)
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        if (sexo==null)
            throw new IllegalArgumentException("Sexo não pode ser nulo");
        if (tipoSanguineo==null)
            throw new IllegalArgumentException("Tipo sanguíneo não pode ser nulo");
    }

    // doador criado a partir do BD, já tem id
    public Doador(int id, String nome, String cpf, LocalDate dataNascimento, Sexo sexo, TipoSanguineo tipoSanguineo, double peso, LocalDate dataUltimaDoacao) {
        validarDados(nome, cpf, dataNascimento, sexo, tipoSanguineo);
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.dataUltimaDoacao = dataUltimaDoacao;
    }

    // doador criado pelo usuario
    public Doador(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, TipoSanguineo tipoSanguineo, double peso, LocalDate dataUltimaDoacao) {
            this(0,nome,cpf,dataNascimento,sexo,tipoSanguineo, peso, dataUltimaDoacao);
    }

    @Override
    public String toString() {
        return "Doador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", tipoSanguineo=" + tipoSanguineo +
                ", peso=" + peso +
                ", dataUltimaDoacao=" + dataUltimaDoacao +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public LocalDate getDataUltimaDoacao() {
        return dataUltimaDoacao;
    }

    public void setDataUltimaDoacao(LocalDate dataUltimaDoacao) {
        this.dataUltimaDoacao = dataUltimaDoacao;
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
