import domain.Aluno;
import domain.Cidade;
import domain.Curso;
import adapters.*;
import adapters.Repository;
import usecases.AlunoUseCase;
import usecases.CidadeUseCase;
import usecases.CursoUseCase;


public class Main {

    public static void main(String[] args) {
        CursoSQLiteDAO cursoDAO = new CursoSQLiteDAO();
        Repository<Curso> cursoRepo = new CursoRepository(cursoDAO);
        CursoUseCase cursoUseCase = new CursoUseCase(cursoRepo);

        CidadeSQLiteDAO cidadeDAO = new CidadeSQLiteDAO();
        Repository<Cidade> cidadeRepo = new CidadeRepository(cidadeDAO);
        CidadeUseCase cidadeUseCase = new CidadeUseCase(cidadeRepo);

        AlunoSQLiteDAO alunoDAO = new AlunoSQLiteDAO();
        Repository<Aluno> alunoRepo = new AlunoRepository(alunoDAO);
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
