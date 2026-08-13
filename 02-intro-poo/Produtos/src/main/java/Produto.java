public class Produto {
    private String nome;
    private float preco;
    private int estoque;

    //atributo static para contar quantidade de objetos
    private static int contadorObjetos = 0;

    //metodo static para acessar o atributo static contaor
    public static int getContadorObjetos() {
        return contadorObjetos;
    }

    public boolean reajustarPreco(float reajuste) {
        if (reajuste <= 0 || reajuste > 50)
            return false;

        preco += preco * reajuste / 100;
        return true;
    }

    public boolean baixarEstoque(int quantidade) {
        if (quantidade <= 0 || quantidade > estoque)
            return false;

        this.estoque -= quantidade;
        return true;
    }

    //Exemplo de sobrecarga.
    // Metodo abaixo dá baixa em exatamente 1 unidade
    public boolean baixarEstoque()
    {
        return baixarEstoque(1);
    }

    public boolean alimentarEstoque(int quantidade){
        if (quantidade > 0) {
            this.estoque += quantidade;
            return true;
        }
        return false;
    }

    // Exemplo de sobrecarga de metodo
    // Aqui, ao atualizar o estoque, já atualizo o valor do produto
    public boolean alimentarEstoque(int quantidade, float novoPreco) {
        if (novoPreco <= 0)
            return false;

        if (!alimentarEstoque(quantidade))
            return false;

        this.preco = novoPreco;
        return true;
    }


    public Produto(){
        contadorObjetos++;
    }

    // Neste momento a classe permite criação de objetos sem validação.
   // A validação das regras de domínio será abordada posteriormente
    public Produto(String nome, float preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        contadorObjetos++;
    }

    public Produto(String nome) {
        this.nome = nome;
        contadorObjetos++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

}
