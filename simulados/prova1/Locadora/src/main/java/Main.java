import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Categoria categoria1 = new Categoria("SUV", 600);
            Categoria categoria2 = new Categoria("Compacto", 400);

            Veiculo veiculo1 = new Veiculo("BBB-5678", "Toyota/Corolla Cross",  categoria1);
            Veiculo veiculo2 = new Veiculo("CCC-9101", "VW/Polo",  categoria2);

            Acessorio acessorio1 = new Acessorio("Bebê conforto", 100);
            Acessorio acessorio2 = new Acessorio("Assento de elevação",  50);

            Cliente cliente1 = new Cliente("111.111.111-11", "Joaquim");
            Cliente cliente2 = new Cliente("222.222.222-22", "Joana");

            Locacao locacao1 = new Locacao(LocalDate.of(2026,8,20),
                    LocalDate.of(2026,8,25),veiculo1, cliente1);
            locacao1.incluirAcessorio(acessorio1, acessorio2);
            locacao1.confirmarLocacao();

            System.out.println("Locações do(a) cliente "+cliente1.getNome());
            Iterator<Locacao> itLocacao=cliente1.obterLocacoes(LocalDate.of(2026,8,10));
            while(itLocacao.hasNext()){
                Locacao loc=itLocacao.next();
                System.out.println("Data da locação: "+loc.getDataLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Veículo: "+loc.getVeiculo().getPlaca()+"-"+loc.getVeiculo().getModelo());

            }

            System.out.println("\nAcessórios da locação 1");
            Iterator<Acessorio> itAcessorio=locacao1.obterAcessorios();
            while(itAcessorio.hasNext()){
                Acessorio acessorio=itAcessorio.next();
                System.out.println("Nome: "+acessorio.getNome());
            }

            locacao1.realizarDevolucao(LocalDate.of(2026,8,30));
            System.out.println("\nLocação finalizada");
            System.out.println("model.Cliente: "+locacao1.getCliente().getNome());
            System.out.println("Veículo: "+locacao1.getVeiculo().getPlaca()+"-"+locacao1.getVeiculo().getModelo());
            System.out.println("Valor total: "+locacao1.getValorTotal());
            System.out.println("Multa: "+locacao1.getMultaAtraso());
            System.out.println("Valor a pagar: "+locacao1.getValorPagar());
            System.out.println("Status do carro: "+(locacao1.getVeiculo().isDisponivel()?"Disponível":"Indisponível"));


            Locacao locacao2 = new Locacao(LocalDate.of(2026,8,26),
                    LocalDate.of(2026,9,1),veiculo2, cliente2);
            locacao2.confirmarLocacao();

            System.out.println("\nLocações do(a) cliente "+cliente2.getNome());
            itLocacao=cliente2.obterLocacoes();
            while(itLocacao.hasNext()){
                Locacao loc=itLocacao.next();
                System.out.println("Data da locação: "+loc.getDataLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Veículo: "+loc.getVeiculo().getPlaca()+"-"+loc.getVeiculo().getModelo()+"-"+loc.getVeiculo().getCategoria().getDescricao());
            }

            locacao2.realizarDevolucao(LocalDate.of(2026,8,27));//apenas 1 dia
            System.out.println("\nLocação finalizada");
            System.out.println("model.Cliente: "+locacao2.getCliente().getNome());
            System.out.println("Veículo: "+locacao2.getVeiculo().getPlaca()+"-"+locacao1.getVeiculo().getModelo());
            System.out.println("Valor total: "+locacao2.getValorTotal());
            System.out.println("Multa: "+locacao2.getMultaAtraso());
            System.out.println("Valor a pagar: "+locacao2.getValorPagar());


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }
}
