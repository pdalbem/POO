package model;

import java.time.LocalDate;

public class Aluguel {
    private final LocalDate inicioContrato;
    private final LocalDate fimContrato;
    private StatusAluguel statusAluguel;
    private final Inquilino inquilino;
    private final Imovel imovel;
    private final Corretor corretor;

    public Aluguel(LocalDate inicioContrato, LocalDate fimContrato, Inquilino inquilino, Imovel imovel, Corretor corretor) {
        if (inquilino==null)
            throw new IllegalArgumentException("Inquilino não pode ser nulo.");
        if (corretor==null)
            throw new IllegalArgumentException("Corretor não pode ser nulo.");
        if (imovel==null)
           throw new IllegalArgumentException("Imóvel não pode ser nulo.");
        if (inquilino.getRendaMensal() <= 3 * imovel.getValorAluguel())
            throw new IllegalArgumentException("Renda do inquilino é insuficiente para alugar este imóvel.");
        if (inicioContrato == null || fimContrato == null)
            throw new IllegalArgumentException("Datas de contrato não podem ser nulas.");

        LocalDate minFimContrato = inicioContrato.plusMonths(6);
        if (fimContrato.isBefore(minFimContrato))
            throw new IllegalArgumentException("A duração mínima do aluguel é de 6 meses.");

        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
        this.inquilino = inquilino;
        this.imovel = imovel;
        this.corretor = corretor;
        this.statusAluguel = StatusAluguel.PENDENTE;
    }

    public void confirmarAluguel(){
       if (this.getStatusAluguel()!=StatusAluguel.PENDENTE)
           throw new IllegalStateException("Aluguel já confirmado ou encerrado");

        if (this.imovel.getStatusImovel() == StatusImovel.ALUGADO)
            throw new IllegalStateException("Imóvel já está alugado");

        this.statusAluguel = StatusAluguel.ATIVO;
        this.imovel.setStatusImovel(StatusImovel.ALUGADO);
        this.corretor.calcularComissao(imovel.getValorAluguel()); //calcular comissão do corretor
        this.imovel.incluirAluguel(this);
        this.inquilino.incluirAluguel(this);
    }

    public void encerrarAluguel() {
       if (this.getStatusAluguel()!=StatusAluguel.ATIVO)
           throw new IllegalStateException("Aluguel não ativo ou já encerrado");

        this.statusAluguel = StatusAluguel.ENCERRADO;
        this.imovel.setStatusImovel(StatusImovel.VAGO); //imóvel volta a ficar disponível para outros aluguéis
    }

    public LocalDate getInicioContrato() {
        return inicioContrato;
    }

    public LocalDate getFimContrato() {
        return fimContrato;
    }

    public StatusAluguel getStatusAluguel() {
        return statusAluguel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Corretor getCorretor() {
        return corretor;
    }
}