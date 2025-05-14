import db.DatabaseInitializer;
import exception.EntityAlreadyExistsException;
import dao.AlunoDAOImpl;
import dao.CidadeDAOImpl;
import dao.CursoDAOImpl;
import model.Aluno;
import model.Cidade;
import model.Curso;

import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // cria o BD se não existir
        DatabaseInitializer.init();

        CidadeDAOImpl cidadeDAOImpl = new CidadeDAOImpl();
        CursoDAOImpl cursoDAOImpl = new CursoDAOImpl();
        AlunoDAOImpl alunoDAOImpl = new AlunoDAOImpl();

        Cidade c1 = new Cidade("São Carlos");
        Cidade c2 = new Cidade( "Campinas");
        cidadeDAOImpl.save(c1);
        cidadeDAOImpl.save(c2);

        Curso curso1 = new Curso("Análise e Desenvolvimento de Sistemas");
        Curso curso2 = new Curso( "Engenharia de Software");
        cursoDAOImpl.save(curso1);
        cursoDAOImpl.save(curso2);

        Aluno a1 = new Aluno( "SP1234", "Joaquim", curso1, c1);
        Aluno a2 = new Aluno( "SP5678", "Maria", curso2, c2);

        try {
            alunoDAOImpl.save(a1);
            alunoDAOImpl.save(a2);
        } catch (EntityAlreadyExistsException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nBuscando cursos por nome");
        Iterator<Curso> cursoIterator = cursoDAOImpl.findByName("software");
        while (cursoIterator.hasNext()) {
            Curso next =  cursoIterator.next();
            System.out.println(next.getNome());
        }

        System.out.println("\nBuscando cidade por ID");
        Optional<Cidade> cidadeOptional = cidadeDAOImpl.findById(1);
        if (cidadeOptional.isPresent())
            System.out.println(cidadeOptional.get().getId() + " "+cidadeOptional.get().getNome());
        else
            System.out.println("Cidade não encontrada com ID fornecido");


        System.out.println("\nBuscando curso por ID");
        Optional<Curso> cursoOptional = cursoDAOImpl.findById(1);
        if (cursoOptional.isPresent())
            System.out.println(cursoOptional.get().getId() + " "+cursoOptional.get().getNome());
        else
            System.out.println("Curso não encontrado com ID fornecido");


        System.out.println("\nBuscando aluno por ID");
        Optional<Aluno> alunoOptional;
        alunoOptional = alunoDAOImpl.findById(1);
        if (alunoOptional.isPresent())
            System.out.println(alunoOptional.get().getId() + " "+alunoOptional.get().getNome());
        else
            System.out.println("Aluno não encontrado com ID fornecido");

        System.out.println("\nBuscando aluno por prontuário");
        alunoOptional = alunoDAOImpl.findByProntuario("SP1234");
        if (alunoOptional.isPresent())
            System.out.println(alunoOptional.get().getId() + " "+alunoOptional.get().getNome());
        else
            System.out.println("Aluno não encontrado com prontuário fornecido");


        System.out.println("\nAlunos cadastrados:");
        Iterator<Aluno> it = alunoDAOImpl.findAll();
        while (it.hasNext()) {
            Aluno a = it.next();
            System.out.println(a.getId() + " - " + a.getNome() + " (" + a.getProntuario() + ")");
        }
    }
}
