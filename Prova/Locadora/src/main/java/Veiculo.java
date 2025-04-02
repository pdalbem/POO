import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private final String placa;
    private final String modelo;
    private final int anoFabricacao;
    private boolean disponivel;
    private Categoria categoria;
    private final static List<String> placasExistentes=new ArrayList<>();

    public Veiculo(String placa, String modelo, int anoFabricacao, Categoria categoria) {
        for (String placaExistente : placasExistentes)
            if (placaExistente.equals(placa))
                throw new IllegalArgumentException("Placa já cadastrada");

        placasExistentes.add(placa);
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.setCategoria(categoria);
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }
}
