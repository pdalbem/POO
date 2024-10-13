import domain.Aluno;
import domain.Cidade;
import domain.Curso;
import frameworks.*;
import interfaces.Repository;
import usecases.AlunoUseCase;
import usecases.CidadeUseCase;
import usecases.CursoUseCase;

import java.util.Scanner;


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

        int id;
        id = cursoUseCase.addCurso(curso1);
        curso1.setIdCurso(id);

        id = cursoUseCase.addCurso(curso2);
        curso2.setIdCurso(id);

        Cidade cidade1 = new Cidade(10, "São Carlos");
        Cidade cidade2 = new Cidade(20, "Araraquara");

        id = cidadeUseCase.addCidade(cidade1);
        cidade1.setIdCidade(id);

        id = cidadeUseCase.addCidade(cidade2);
        cidade2.setIdCidade(id);

        Aluno aluno1 = new Aluno("1111", "Maria", curso1, cidade1);
        Aluno aluno2 = new Aluno("2222", "João", curso2, cidade2);

        id = alunoUseCase.addAluno(aluno1);
        aluno1.setIdAluno(id);
        id = alunoUseCase.addAluno(aluno2);
        aluno2.setIdAluno(id);

        for (Curso curso : cursoUseCase.getAllCursos())
            System.out.println(curso);

        for (Cidade cidade : cidadeUseCase.getAllCidades())
            System.out.println(cidade);

        for (Aluno aluno : alunoUseCase.getAllAlunos())
            System.out.println(aluno);

    }
}
