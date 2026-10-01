import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Proprietario proprietario = new Proprietario("111.111.111-11","André","1234-4321","8080");

            Corretor corretor = new Corretor("222.222.222-22","Joaquim","1010");

            Inquilino inquilino = new Inquilino("333.333.333-33", "José",3500);

            Imovel casa = new Casa("Rua XPTO",800, proprietario,"Quadra A", "Lote B");

            Imovel apartamento =new Apartamento("Rua B",1100, proprietario,"Edifício", 10);

            exibirImoveisVagos(proprietario); // metodo da Main, veja abaixo

            Aluguel aluguel1 = new Aluguel(LocalDate.of(2026, 9, 20),
                    LocalDate.of(2027, 9, 20), inquilino, casa, corretor);
            aluguel1.confirmarAluguel();

            exibirImoveisVagos(proprietario);

            Aluguel aluguel2 = new Aluguel(LocalDate.of(2026, 6, 25),
                    LocalDate.of(2027, 10, 25), inquilino, apartamento, corretor);
            aluguel2.confirmarAluguel();

            exibirRendimentos(proprietario);

            exibirInquilinoAtual(casa);
            exibirInquilinoAtual(apartamento);

            exibirComissaoCorretor(corretor);

            aluguel1.encerrarAluguel();
            aluguel2.encerrarAluguel();

            exibirImoveisVagos(proprietario);

            exibirAlugueis(casa);
            exibirAlugueis(apartamento);

            //polimorfismo
            List<Pessoa> listaPessoas = new ArrayList<>();
            listaPessoas.add(proprietario);
            listaPessoas.add(inquilino);
            listaPessoas.add(corretor);
            for (Pessoa p: listaPessoas)
                p.exibirInfo();


            // Testar o Comparable
            List<Imovel> listaImoveis = new ArrayList<>();
            listaImoveis.add(apartamento);
            listaImoveis.add(casa);

            for (Imovel i: listaImoveis)
                System.out.println(i.getValorAluguel());

            Collections.sort(listaImoveis); // ordena pelo valorAluguel

            for (Imovel i: listaImoveis)
                System.out.println(i.getValorAluguel());
            
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("ERRO:" + e.getMessage());
        }
    }

    private static void exibirAlugueis(Imovel imovel) { //polimorfismo
        System.out.println("\nAluguéis do imóvel "+imovel.getClass().getSimpleName());
        Iterator<Aluguel> aluguelIterator = imovel.obterAlugueis();
        while (aluguelIterator.hasNext()) {
            Aluguel next =  aluguelIterator.next();
            System.out.println("Data início: "+next.getInicioContrato().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    + ", Data fim: "+next.getFimContrato().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    private static void exibirComissaoCorretor(Corretor corretor) {
        System.out.println("\nComissão do corretor "+corretor.getNome() + ": "+corretor.getTotalComissoes());
    }

    private static void exibirInquilinoAtual(Imovel imovel) {
        Inquilino inq = imovel.obterInquilinoAtual();
        if (inq!=null){
            System.out.print("\nInquilino atual do imóvel "+imovel.getClass().getSimpleName());
            inq.exibirInfo();
        }
    }

    private static void exibirRendimentos(Proprietario proprietario) {
        System.out.println("\nRendimentos referentes a aluguéis do(a) proprietário(a) "+ proprietario.getNome()+": "
                +proprietario.calcularRendimentoMensal());
    }

    private static void exibirImoveisVagos(Proprietario proprietario) {
        System.out.println("\nImóveis vagos do(a) proprietário(a) "+proprietario.getNome());
        Iterator<Imovel> imovelIterator = proprietario.obterImoveisVagos();
        while (imovelIterator.hasNext()) {
            Imovel next =  imovelIterator.next();
            next.exibirInfo(); //polimorfismo
        }
    }
}