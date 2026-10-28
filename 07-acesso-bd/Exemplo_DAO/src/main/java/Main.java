import data.dao.AlunoDAOImpl;
import data.dao.CursoDAOImpl;
import data.db.DatabaseInitializer;
import exception.EntityAlreadyExistsException;
import exception.EntityNotFoundException;
import model.Aluno;
import model.Curso;
import service.AlunoService;
import service.CursoService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseInitializer.initialize();

            CursoService cursoService = new CursoService(new CursoDAOImpl());
            AlunoService alunoService = new AlunoService(new AlunoDAOImpl());

            Curso curso1 = new Curso("Análise e Desenvolvimento de Sistemas");
            curso1 = cursoService.cadastrar(curso1);

            Curso curso2 = new Curso("Engenharia de Software");
            curso2 = cursoService.cadastrar(curso2);

            Aluno aluno1 = new Aluno("SC1234", "Joaquim", curso1);
            aluno1 = alunoService.cadastrar(aluno1);

            Aluno aluno2 = new Aluno("SC5678", "Maria", curso2);
            aluno2 = alunoService.cadastrar(aluno2);

            System.out.println("Cursos com 'software' no nome:");
            for (Curso c : cursoService.buscarPorNome("software"))
                System.out.println(c.getNome());

            System.out.println("Curso com id 1:");
            Optional<Curso> cursoPorId = cursoService.buscarPorId(1);
            if (cursoPorId.isPresent())
                System.out.println(cursoPorId.get().getNome());
            else
                System.out.println("Curso não encontrado");

            System.out.println("Alunos cadastrados: ");
            for (Aluno a : alunoService.buscarTodos())
                System.out.println(a.getNome());
        }catch (IllegalArgumentException | EntityAlreadyExistsException | EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
