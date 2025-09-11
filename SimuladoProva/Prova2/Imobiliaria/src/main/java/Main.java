import imobiliaria.*;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Proprietario proprietario = new Proprietario("111.111.111-11","Maria","1234-4321","8888");
        Corretor corretor = new Corretor("222.222.222-22","Joaquim","1010");
        Inquilino inquilino = new Inquilino("333.333.333-33", "José",3500);

        try {
            Casa casa = new Casa("Rua A",800, proprietario,"Quadra A", "Lote B");
            Apartamento apartamento =new Apartamento("Rua B",1100, proprietario,"Edifício", 10);

            exibirImoveisVagos(proprietario);

            Aluguel aluguel1 = new Aluguel(LocalDate.of(2025, 4, 23),
                    LocalDate.of(2025, 10, 23), inquilino, casa, corretor);

            //Tentando acessar o método protected setAlugado passando false como parâmetro
            //casa.setAlugado(false);
            //Isso geraria inconsitência, pois a casa está alugada
            //Repare na solução: classe Main está em package diferente da classe Imovel
            //Reveja modificador de acesso protected
            
            exibirImoveisVagos(proprietario);

            Aluguel aluguel2 = new Aluguel(LocalDate.of(2025, 4, 23),
                    LocalDate.of(2025, 10, 23), inquilino, apartamento, corretor);

            exibirRendimentos(proprietario);

            exibirInquilinoAtual(casa);
            exibirInquilinoAtual(apartamento);

            exibirComissaoCorretor(corretor);

            aluguel1.encerrarAluguel();
            aluguel2.encerrarAluguel();

            exibirImoveisVagos(proprietario);

            exibirAlugueis(casa);
            exibirAlugueis(apartamento);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirAlugueis(Imovel imovel) {
        System.out.println("\nAluguéis do imóvel "+imovel.getClass().getName());
        Iterator<Aluguel> aluguelIterator = imovel.obterAlugueis();
        while (aluguelIterator.hasNext()) {
            Aluguel next =  aluguelIterator.next();
            System.out.println("Data início: "+next.getInicioContrato()
                    + ", Data fim: "+next.getFimContrato());
        }
    }

    private static void exibirComissaoCorretor(Corretor corretor) {
        System.out.println("\nComissão do corretor "+corretor.getNome() + ": "+corretor.getComissao());
    }

    private static void exibirInquilinoAtual(Imovel imovel) {
        Inquilino inq = imovel.obterInquilinoAtual();
        if (inq!=null){
            System.out.print("\nimobiliaria.Inquilino atual do imóvel "+imovel.getClass().getName());
            inq.exibirInfo();
        }
    }

    private static void exibirRendimentos(Proprietario proprietario) {
        System.out.println("\nRendimentos referentes a aluguéis do proprietário "+ proprietario.getNome()+": "
                +proprietario.calcularRendimentoMensal());
    }

    private static void exibirImoveisVagos(Proprietario proprietario) {
        System.out.println("\nImóveis vagos do proprietário "+proprietario.getNome());
        Iterator<Imovel> imovelIterator = proprietario.obterImoveisVagos();
        while (imovelIterator.hasNext()) {
            Imovel next =  imovelIterator.next();
            next.exibirInfo();
        }
    }
}
