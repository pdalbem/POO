
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Locacao {
    private final LocalDate dataLocacao;
    private final LocalDate dataPrevistaDevolucao;
    private LocalDate dataRealDevolucao;
    private double valorTotal;
    private double multaAtraso;
    private double valorPagar;
    private boolean locacaoAtiva;
    private final Veiculo veiculo;
    private final Cliente cliente;
    private final List<Acessorio> acessorios = new ArrayList<>();

    public Locacao(LocalDate dataLocacao, LocalDate dataPrevistaDevolucao, Veiculo veiculo, Cliente cliente) {
        if (dataPrevistaDevolucao.isBefore(dataLocacao))
            throw new IllegalArgumentException("Data prevista de devolução não pode ser anterior à de locação");

        if (ChronoUnit.DAYS.between(dataLocacao,dataPrevistaDevolucao) < 2)
            throw new IllegalArgumentException("A locação mínima é de dois dias!");

        if (!veiculo.isDisponivel())
            throw new IllegalArgumentException("Veículo indisponível!");

        if (cliente.possuiLocacaoAtiva())
            throw new IllegalArgumentException("O cliente já possui uma locação ativa!");


        this.dataLocacao = dataLocacao;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.locacaoAtiva = true;
        this.veiculo = veiculo;
        this.veiculo.setDisponivel(false);
        this.cliente = cliente;
        this.cliente.adicionarLocacoes(this);
    }

    public void realizarDevolucao(LocalDate dataDevolucao) {
        if (dataDevolucao.isBefore(this.dataLocacao))
            throw new IllegalArgumentException("Data de devolução não pode ser anterior à da locação");

        this.dataRealDevolucao = dataDevolucao;
        this.locacaoAtiva = false;
        this.veiculo.setDisponivel(true);

        calcularTotal();
        calcularMulta();

        this.valorPagar= this.getMultaAtraso() + this.valorTotal;
    }

    private void calcularTotal() {
        int qtdDiasLocacao = (int) ChronoUnit.DAYS.between(this.dataLocacao, this.dataRealDevolucao);
        double totalDiariaVeiculo=qtdDiasLocacao * this.veiculo.getCategoria().getValorDiaria();

        double totalDiariaAcessorios=0;
        for (Acessorio acessorio : this.acessorios) {
            totalDiariaAcessorios += acessorio.getValorDiaria()*qtdDiasLocacao;
            acessorio.devolverAcessorio();
        }
        this.valorTotal = totalDiariaVeiculo + totalDiariaAcessorios;
    }

    private void calcularMulta() {
        this.multaAtraso = 0;
        if (this.dataRealDevolucao.isAfter(this.dataPrevistaDevolucao))
            this.multaAtraso=this.valorTotal*0.10;
    }

    public void incluirAcessorio(Acessorio...acessorio){
        for(Acessorio ac:acessorio) {
            if (ac.getQuantidadeDisponivel() == 0)
                throw new IllegalArgumentException("Acessório "+ac.getNome()+" indisponível para locação");
            this.acessorios.add(ac);
            ac.retirarAcessorio();
        }
    }

    public void removerAcessorio(Acessorio acessorio){
        if (this.acessorios.remove(acessorio))
            acessorio.devolverAcessorio();
        else
            throw new IllegalArgumentException("Acessório não encontrado nesta locação.");
    }

    public boolean isLocacaoAtiva() {
        return locacaoAtiva;
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
        return this.acessorios.iterator();
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public double getValorPagar() {
        return valorPagar;
    }
}
