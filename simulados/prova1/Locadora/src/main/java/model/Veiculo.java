package model;

import java.util.HashSet;
import java.util.Set;

public class Veiculo {
    private final String placa;
    private final String modelo;
    private boolean disponivel;
    private final Categoria categoria;
    private final static Set<String> placasExistentes=new HashSet<>(); //poderia ser Arraylist, mas preferi HashSet por representar naturalmente conjunto de valores únicos

    public Veiculo(String placa, String modelo, Categoria categoria) {
        if (placa==null || placa.isBlank())
            throw new IllegalArgumentException("Placa não pode ser nula/vazia");

        placa = placa.toUpperCase();

        if (!placasExistentes.add(placa))
            throw new IllegalArgumentException("Placa já cadastrada");

        if (categoria==null)
            throw new IllegalArgumentException("Categoria não pode ser nula");

        this.placa = placa;
        this.modelo = modelo;
        this.categoria = categoria;
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    //visibilidade package-private.
    void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getModelo() {
        return modelo;
    }


}
