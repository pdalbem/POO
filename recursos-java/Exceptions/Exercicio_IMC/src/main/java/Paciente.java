public class Paciente {
    private String nome;
    private double peso;
    private double altura;

    public double calcularIMC(){
        return this.peso/Math.pow(this.altura,2);
    }

    public String obterClassificacao(double imc){
        if (imc<18.5)
            return "Abaixo do peso";
        else if (imc<24.9)
            return "Peso normal";
        else if (imc<29.9)
            return "Acima do peso";
        else if (imc<34.9)
            return "Obesidade I";
        else if (imc<39.9)
            return "Obesidade II";
        else return "Obesidade III";
    }

    public void validarNome(String nome){
        if (nome==null || nome.isBlank())
            throw new IllegalArgumentException("Erro: nome não pode ser nulo");
    }

    public void validarPeso(double peso){
        if (peso<0)
            throw  new IllegalArgumentException("Erro: peso não pode ser negativo");
    }

    public void validarAltura(double altura){
        if (altura<0)
            throw new IllegalArgumentException("Erro: altura não pode ser negativa");
    }

    public Paciente(String nome, double peso, double altura) {
        validarNome(nome);
        validarPeso(peso);
        validarAltura(altura);

        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        validarPeso(peso);
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        validarAltura(altura);
        this.altura = altura;
    }
}
