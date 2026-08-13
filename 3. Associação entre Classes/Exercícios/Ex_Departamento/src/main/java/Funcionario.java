public class Funcionario {
    private String nome;
    private String cpf;
    private float salario;
    private Departamento departamento;

    public Funcionario(String nome, String cpf, float salario, Departamento departamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.departamento = departamento;
        this.departamento.adicionarFuncionario(this); //Objeto funcionario é criado e já atualiza departamento, mantendo a associação nos 2 lados
    }

    public void transferirDepartamento(Departamento novoDepartamento){
        this.departamento.removerFuncionario(this);
        this.departamento =  novoDepartamento;
        this.departamento.adicionarFuncionario(this);
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

}
