package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Locacao {
    private final LocalDate dataLocacao;
    private final LocalDate dataPrevistaDevolucao;
    private LocalDate dataRealDevolucao;
    private double valorTotal;
    private double multaAtraso;
    private double valorPagar;
    private StatusLocacao statusLocacao;
    private final Veiculo veiculo;
    private final Cliente cliente;
    private final List<Acessorio> acessorios = new ArrayList<>();

    public Locacao(LocalDate dataLocacao, LocalDate dataPrevistaDevolucao, Veiculo veiculo, Cliente cliente) {
        if (dataLocacao==null)
            throw new IllegalArgumentException("Data da locação não pode ser nula");
        if (dataPrevistaDevolucao==null)
            throw new IllegalArgumentException("Data prevista da devolução não pode ser nula");
        if (ChronoUnit.DAYS.between(dataLocacao,dataPrevistaDevolucao) < 2)
            throw new IllegalArgumentException("A locação mínima é de dois dias!");
        if (veiculo==null)
            throw new IllegalArgumentException("Veículo não pode ser nulo");
        if (cliente==null)
            throw new IllegalArgumentException("model.Cliente não pode ser nulo");

        this.dataLocacao = dataLocacao;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.statusLocacao = StatusLocacao.PENDENTE;
   }

    public void confirmarLocacao(){
        if (this.statusLocacao!=StatusLocacao.PENDENTE)
            throw new IllegalArgumentException("Locação não pode ser confirmada. Seu status é: "+this.statusLocacao);

        if (!this.veiculo.isDisponivel())
            throw new IllegalArgumentException("Veículo indisponível!");

        if (this.cliente.possuiLocacaoAtiva())
            throw new IllegalArgumentException("O cliente já possui locação ativa!");

        this.statusLocacao = StatusLocacao.ATIVA;
        this.veiculo.setDisponivel(false);
        this.cliente.adicionarLocacao(this); // faz a associacao bidirecional
    }


    public void realizarDevolucao(LocalDate dataDevolucao) {
        if (this.statusLocacao!=StatusLocacao.ATIVA)
            throw new IllegalArgumentException("Não foi possível efetuar devolução. Status da locação é: "+this.statusLocacao);

        if (dataDevolucao.isBefore(this.dataLocacao))
            throw new IllegalArgumentException("Data de devolução não pode ser anterior à da locação");

        this.dataRealDevolucao = dataDevolucao;

        this.valorTotal = calcularTotal();
        this.multaAtraso = calcularMulta();
        this.valorPagar=  this.valorTotal + this.multaAtraso;

        this.statusLocacao = StatusLocacao.ENCERRADA;
        this.veiculo.setDisponivel(true);
    }

    private double calcularTotal() {
        //garante cobrar, no mínimo, 2 diárias
        long qtdDiasCobrados =  Math.max(ChronoUnit.DAYS.between(this.dataLocacao, this.dataRealDevolucao),2);

        double totalDiariaVeiculo = qtdDiasCobrados * this.veiculo.getCategoria().getValorDiaria();

        double totalDiariaAcessorios = 0;
        for (Acessorio acessorio : this.acessorios)
            totalDiariaAcessorios += acessorio.getValorDiaria() * qtdDiasCobrados;

        return totalDiariaVeiculo + totalDiariaAcessorios;
    }

    private double calcularMulta() {
        double valorMulta = 0;
        if (this.dataRealDevolucao.isAfter(this.dataPrevistaDevolucao))
            valorMulta = this.valorTotal * 0.10;
        return valorMulta;
    }

    public void incluirAcessorio(Acessorio...acessorio) {
        if (this.statusLocacao!=StatusLocacao.PENDENTE)
            throw new IllegalStateException("Locação não permite incluir acessórios");

        for (Acessorio a: acessorio)
            if (a==null)
                throw new IllegalArgumentException("Acessório não pode ser null");

        Collections.addAll(this.acessorios, acessorio);
    }

    public void removerAcessorio(Acessorio acessorio){
        if (this.statusLocacao!=StatusLocacao.PENDENTE)
            throw new IllegalStateException("Locação não permite remover acessórios");

        this.acessorios.remove(acessorio);
    }

    public StatusLocacao getStatusLocacao() {
        return statusLocacao;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataRealDevolucao() {
        return dataRealDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Iterator<Acessorio> obterAcessorios(){
        return Collections.unmodifiableList(this.acessorios).iterator();
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public double getValorPagar() {
        return valorPagar;
    }
}
