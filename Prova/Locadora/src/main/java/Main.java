import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Categoria categoria1 = new Categoria("SUV", 600);
            Categoria categoria2 = new Categoria("Compacto", 400);

            Veiculo veiculo1 = new Veiculo("BBB-5678", "Toyota/Corolla Cross", 2024, categoria1);
            Veiculo veiculo2 = new Veiculo("CCC-9101", "VW/Polo", 2022, categoria2);

            Acessorio acessorio1 = new Acessorio("Bebê conforto", 2, 100);
            Acessorio acessorio2 = new Acessorio("Assento de elevação", 1, 50);

            // Tentando adicionar veículo com placa repetida. Saída esperada: "Placa já cadastrada"
             //Veiculo veiculo3 = new Veiculo("CCC-9101", "VW/Polo", 2022, categoria2);

            Cliente cliente1 = new Cliente("111.111.111-11", "Joaquim");
            Cliente cliente2 = new Cliente("222.222.222-22", "Joana");

            //Tentando criar locação com menos de 2 dias. Gera exceção. Saída esperada: "Locação mínima de 2 dias"
            Locacao locacaoMenosDoisDias = new Locacao(LocalDate.of(2025,3,26),LocalDate.of(2025,3,27),veiculo1, cliente1);

            //Tentando criar locação com dataPrevistaDevolucao anterior a DataLocacao. Gera exceção. Saída esperada: "Data prevista de devolução não pode ser anterior à de locação"
            Locacao locacaoDatasErradas = new Locacao(LocalDate.of(2025,3,26),LocalDate.of(2025,3,25),veiculo1, cliente1);

            Locacao locacao1 = new Locacao(LocalDate.of(2025,3,26),
                                           LocalDate.of(2025,4,1),veiculo1, cliente1);
            locacao1.adicionarAcessorio(acessorio2);

            System.out.println("Locações do cliente "+cliente1.getNome());
            Iterator<Locacao> itLocacao=cliente1.obterLocacoes(LocalDate.of(2025,3,1));
            while(itLocacao.hasNext()){
                Locacao loc=itLocacao.next();
                System.out.println("Data da locação: "+loc.getDataLocacao());
                System.out.println("Veículo: "+loc.getVeiculo().getPlaca()+"-"+loc.getVeiculo().getModelo());

            }

            Locacao locacao2 = new Locacao(LocalDate.of(2025,3,26),
                                                         LocalDate.of(2025,4,1),veiculo2, cliente2);

            locacao2.adicionarAcessorio(acessorio2); //Gera exceção. Saída esperada: "Acessório indisponível

            System.out.println("Locações do cliente "+cliente2.getNome());
           itLocacao=cliente2.obterLocacoes(categoria2);
            while(itLocacao.hasNext()){
                Locacao loc=itLocacao.next();
                System.out.println("Data da locação: "+loc.getDataLocacao());
                System.out.println("Veículo: "+loc.getVeiculo().getPlaca()+"-"+loc.getVeiculo().getModelo()+"-"+loc.getVeiculo().getCategoria().getDescricao());

            }

            locacao1.realizarDevolucao(LocalDate.of(2025,4,2));
            System.out.println(locacao1.getVeiculo().isDisponivel()); //Saída esperada: True

            Iterator<Acessorio> itAcessorio=locacao1.iterator();
            while(itAcessorio.hasNext()){
                Acessorio acessorio=itAcessorio.next();
                System.out.println("Nome: "+acessorio.getNome()); //Saída esperada: Assento de elevação
                System.out.println("Qtd. disponível: "+acessorio.getQuantidadeDisponivel()); //Saída esperada 1
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
