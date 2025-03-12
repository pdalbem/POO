public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;
    private Departamento departamento;

    public Funcionario(String nome, String cpf, double salario) {
        if (salario<0)
            throw new IllegalArgumentException("Salário não pode ser negativo");

        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Funcionario(String nome, String cpf, double salario, Departamento departamento) {
        if (salario<0)
            throw new IllegalArgumentException("Salário não pode ser negativo");

        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
