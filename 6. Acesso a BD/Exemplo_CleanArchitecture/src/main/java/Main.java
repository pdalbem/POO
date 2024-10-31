import adapters.dao.*;
import adapters.repository.*;
import domain.entity.Aluno;
import domain.entity.Cidade;
import domain.entity.Curso;
import domain.repository.AlunoRepository;
import domain.repository.CidadeRepository;
import domain.repository.CursoRepository;
import usecases.AlunoUseCase;
import usecases.CidadeUseCase;
import usecases.CursoUseCase;


public class Main {

    public static void main(String[] args) {
        CursoDAO cursoDAO = new CursoDAOImpl();
        CursoRepository cursoRepo = new CursoRepositoryImpl(cursoDAO);
        CursoUseCase cursoUseCase = new CursoUseCase(cursoRepo);

        CidadeDAO cidadeDAO = new CidadeDAOImpl();
        CidadeRepository cidadeRepo = new CidadeRepositoryImpl(cidadeDAO);
        CidadeUseCase cidadeUseCase = new CidadeUseCase(cidadeRepo);

        AlunoDAO alunoDAO = new AlunoDAOImpl();
        AlunoRepository alunoRepo = new AlunoRepositoryImpl(alunoDAO);
        AlunoUseCase alunoUseCase = new AlunoUseCase(alunoRepo);

        Curso curso1 = new Curso("Java");
        Curso curso2 = new Curso("POO");

        cursoUseCase.addCurso(curso1);
        cursoUseCase.addCurso(curso2);

        Cidade cidade1 = new Cidade(10, "São Carlos");
        Cidade cidade2 = new Cidade(20, "Araraquara");

        cidadeUseCase.addCidade(cidade1);
        cidadeUseCase.addCidade(cidade2);

        Aluno aluno1 = new Aluno("1111", "Maria", curso1, cidade1);
        Aluno aluno2 = new Aluno("2222", "João", curso2, cidade2);

        alunoUseCase.addAluno(aluno1);
        alunoUseCase.addAluno(aluno2);

        for (Curso curso : cursoUseCase.getAllCursos())
            System.out.println(curso);

        for (Cidade cidade : cidadeUseCase.getAllCidades())
            System.out.println(cidade);

        for (Aluno aluno : alunoUseCase.getAllAlunos())
            System.out.println(aluno);

    }
}
