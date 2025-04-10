import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Proprietario proprietario = new Proprietario("Maria","11111-1111");
            System.out.println("Dados do proprietário");
            System.out.println(proprietario);

            Mecanico mecanico = new Mecanico("Joaquim",3500.00);
            System.out.println("\nDados do mecânico");
            System.out.println(mecanico);

            Veiculo carro = new Carro("ABC-1234","VW/GOL",proprietario,5);
            Veiculo moto = new Moto("XYZ-9874", "Honda/CG125",  proprietario,125);

            Manutencao manutencao1 = new Manutencao(LocalDate.now(),1400.00, carro,mecanico);
            Manutencao manutencao2 = new Manutencao(LocalDate.now(),980.00, carro, mecanico);

            System.out.println("\nDados da manutenção do veículo "+ carro.getPlaca());
            Iterator<Manutencao> itManutencao = carro.obterManutencoes();
            while (itManutencao.hasNext()) {
                Manutencao m =  itManutencao.next();
                System.out.println(m);
            }

            Manutencao manutencao3 = new Manutencao(LocalDate.now(),500,moto,mecanico);
            System.out.println("\nDados da manutenção do veículo "+moto.getPlaca());
            System.out.println(manutencao3);

            System.out.println("\nVeículos do(a) proprietário(a) "+proprietario.getNome());
            Iterator<Veiculo> it = proprietario.obterVeiculos();
            while (it.hasNext()) {
                Veiculo v =  it.next();
                System.out.println(v);
            }

            System.out.println("\nDados dos veículos");
            List<Veiculo> listaVeiculos = new ArrayList<>();
            listaVeiculos.add(carro);
            listaVeiculos.add(moto);
            for (Veiculo v:listaVeiculos)
                System.out.println(v);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
