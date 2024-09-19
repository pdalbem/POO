public class Main {
    public static void main(String[] args) {
        Ingrediente tomate = new Ingrediente("Tomate");
        Ingrediente mucarela = new Ingrediente("Muçarela");
        Ingrediente manjericao = new Ingrediente("Manjericão");

        Pizza margherita = new Pizza("Margherita", 50.00, false);
        margherita.adicionarIngredientes(mucarela,tomate,manjericao);

        System.out.println(margherita.obterDados());

        

    }
}
