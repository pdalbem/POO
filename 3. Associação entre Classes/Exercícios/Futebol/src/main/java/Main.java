public class Main {
    public static void main(String[] args) {
        Jogador j1 = new Jogador("Jogador1", "atacante",10);
        Jogador j2 = new Jogador("Jogador2", "goleiro",1);
        Jogador j3 = new Jogador("Jogador3", "atacante",10);
        Jogador j4 = new Jogador("Jogador4", "goleiro",1);

        Time brasil = new Time("Brasil",5);
        brasil.adicionarJogador(j1,j2);

        Time argentina = new Time("Argentina",3);
        argentina.adicionarJogador(j3,j4);

        Estadio estadio = new Estadio("Estádio", "Rio de Janeiro");

        Partida partida=new Partida("20/09/2024","20h",brasil,argentina,estadio);
        partida.atualizarResultado(3,1);

    }
}
