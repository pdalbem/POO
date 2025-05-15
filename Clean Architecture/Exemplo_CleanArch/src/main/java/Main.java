import adapter.config.DatabaseInitializer;
import adapter.repository.UseCaseFactory;
import domain.exception.EntityAlreadyExistsException;
import domain.entity.Aluno;
import domain.entity.Cidade;
import domain.entity.Curso;
import usecase.AlunoUseCase;
import usecase.CidadeUseCase;
import usecase.CursoUseCase;

import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // cria o BD se não existir
        DatabaseInitializer.init();

        CidadeUseCase cidadeUseCase = UseCaseFactory.createCidadeUseCase();
        CursoUseCase cursoUseCase = UseCaseFactory.createCursoUseCase();
        AlunoUseCase alunoUseCase = UseCaseFactory.createAlunoUseCase();


        try {
            Cidade c1 = new Cidade("São Carlos");
            Cidade c2 = new Cidade( "Campinas");
            cidadeUseCase.insertCidade(c1);
            cidadeUseCase.insertCidade(c2);

            Curso curso1 = new Curso("Análise e Desenvolvimento de Sistemas");
            Curso curso2 = new Curso( "Engenharia de Software");
            cursoUseCase.insertCurso(curso1);
            cursoUseCase.insertCurso(curso2);

            Aluno a1 = new Aluno( "SP1234567", "Joaquim", curso1, c1);
            Aluno a2 = new Aluno( "SP5678567", "Maria", curso2, c2);
            alunoUseCase.insertAluno(a1);
            alunoUseCase.insertAluno(a2);


            System.out.println("\nBuscando cursos por nome");
            Iterator<Curso> cursoIterator = cursoUseCase.findCursoByName("software");
            while (cursoIterator.hasNext()) {
                Curso next =  cursoIterator.next();
                System.out.println(next.getNome());
            }

            System.out.println("\nBuscando cidade por ID");
            Optional<Cidade> cidadeOptional = cidadeUseCase.findCidadeById(1);
            if (cidadeOptional.isPresent())
                System.out.println(cidadeOptional.get().getId() + " "+cidadeOptional.get().getNome());
            else
                System.out.println("Cidade não encontrada com ID fornecido");


            System.out.println("\nBuscando curso por ID");
            Optional<Curso> cursoOptional = cursoUseCase.findCursoById(1);
            if (cursoOptional.isPresent())
                System.out.println(cursoOptional.get().getId() + " "+cursoOptional.get().getNome());
            else
                System.out.println("Curso não encontrado com ID fornecido");


            System.out.println("\nBuscando aluno por ID");
            Optional<Aluno> alunoOptional;
            alunoOptional = alunoUseCase.findAlunoById(1);
            if (alunoOptional.isPresent())
                System.out.println(alunoOptional.get().getId() + " "+alunoOptional.get().getNome());
            else
                System.out.println("Aluno não encontrado com ID fornecido");

            System.out.println("\nBuscando aluno por prontuário");
            alunoOptional = alunoUseCase.findAlunoByProntuario("SP1234");
            if (alunoOptional.isPresent())
                System.out.println(alunoOptional.get().getId() + " "+alunoOptional.get().getNome());
            else
                System.out.println("Aluno não encontrado com prontuário fornecido");


            System.out.println("\nAlunos cadastrados:");
            Iterator<Aluno> it = alunoUseCase.listAllAlunos();
            while (it.hasNext()) {
                Aluno a = it.next();
                System.out.println(a.getId() + " - " + a.getNome() + " (" + a.getProntuario() + ")");
            }

        } catch (EntityAlreadyExistsException e) {
            System.out.println("ERRO: "+e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("ERRO:" +e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("ERRO: "+e.getMessage());
        }
    }
}
