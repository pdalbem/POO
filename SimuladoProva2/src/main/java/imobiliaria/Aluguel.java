package imobiliaria;

import java.time.LocalDate;

public class Aluguel {
    private final LocalDate inicioContrato;
    private final LocalDate fimContrato;
    private boolean ativo;
    private final Inquilino inquilino;
    private final Imovel imovel;
    private final Corretor corretor;

    public Aluguel(LocalDate inicioContrato, LocalDate fimContrato, Inquilino inquilino, Imovel imovel, Corretor corretor) {
        if (inquilino==null)
            throw new IllegalArgumentException("imobiliaria.Inquilino não pode ser nulo.");
        if (corretor==null)
            throw new IllegalArgumentException("imobiliaria.Corretor não pode ser nulo.");
        if (imovel==null)
           throw new IllegalArgumentException("Imóvel não pode ser nulo.");
        if (imovel.estaAlugado())
            throw new IllegalArgumentException("Imóvel já está alugado.");
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
        this.ativo=true; //este contrato de aluguel passa a estar ativo
        this.corretor.calcularComissao(imovel.getValorAluguel()); //calcular comissão do corretor
        this.imovel.incluirAluguel(this); //imóvel passa a ficar indisponível para aluguel
        this.inquilino.incluirAluguel(this);
    }

    public LocalDate getInicioContrato() {
        return inicioContrato;
    }

    public LocalDate getFimContrato() {
        return fimContrato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void encerrarAluguel() {
        this.ativo = false; // contrato de aluguel passa ser inativo
        this.imovel.setAlugado(false); //imóvel volta a ficar disponível para outros aluguéis
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Corretor getCorretor() {
        return corretor;
    }
}
