import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Time {
    private String pais;
    private int quantidadeTitulos;
    private List<Jogador> jogadores=new ArrayList<>();

    public void adicionarJogador(Jogador... j){
        Collections.addAll(jogadores,j);
    }

    public void removerJogador(Jogador j){
        jogadores.remove(j);
    }

    public Time(String pais, int quantidadeTitulos) {
        this.setPais(pais);
        this.setQuantidadeTitulos(quantidadeTitulos);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQuantidadeTitulos() {
        return quantidadeTitulos;
    }

    public void setQuantidadeTitulos(int quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
