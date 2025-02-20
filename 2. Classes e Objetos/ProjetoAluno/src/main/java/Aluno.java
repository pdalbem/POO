public class Aluno {
    private String nome;
    private String curso;
    private double[] notas = new double[3];
    private static int quantidadeAlunos=0;

    public static int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    // Nao faz sentido, pode gerar inconsistencia
   //    public static void setQuantidadeAlunos(int quantidadeAlunos) {
   //        Aluno.quantidadeAlunos = quantidadeAlunos;
   //    }

    //sobrecarga de metodo
    public double calcularMedia(){
        double soma=0;
        for (double nota: getNotas())
            soma+=nota;
        return soma/ getNotas().length;
    }

    public double calcularMedia(double[] pesos){
       if (getNotas().length!= pesos.length)
           throw new IllegalArgumentException("ERRO: A quantidade de notas deve ser igual a quantidade de pesos");

        double soma=0;
        double totalPeso=0;
        for (int i = 0; i< getNotas().length; i++){
            soma+= getNotas()[i]*pesos[i];
            totalPeso+=pesos[i];
        }
        if (totalPeso==0)
            throw new ArithmeticException("ERRO: divisão por zero");

        return soma/totalPeso;
    }

    public Aluno() {
        quantidadeAlunos++;
    }

    public Aluno(String nome, String curso) {
        this.setNome(nome);
        this.setCurso(curso);
        quantidadeAlunos++;
    }

    public Aluno(String nome, String curso, double[] notas) {
        this.setNome(nome);
        this.setCurso(curso);
        this.setNotas(notas);
        quantidadeAlunos++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}
