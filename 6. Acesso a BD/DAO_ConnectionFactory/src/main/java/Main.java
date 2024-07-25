import data.*;
import model.Aluno;
import model.Cidade;
import model.Curso;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         Curso curso1 = new Curso(100,"Java");
         Curso curso2 = new Curso(200,"POO");

         CursoSQLiteDAO cursoDAO = new CursoSQLiteDAO();
         //Outra forma de instanciar o DAO:
         //DAO<Curso> cursoDAO = new CursoSQLiteDAO();

         cursoDAO.save(curso1);
         cursoDAO.save(curso2);

        
        Cidade cidade1 = new Cidade(10, "São Carlos");
        Cidade cidade2 = new Cidade(20, "Araraquara");

        CidadeSQLiteDAO cidadeDAO = new CidadeSQLiteDAO();
        //Outra forma de instanciar o DAO:
        //DAO<Cidade> cidadeDAO = new CidadeSQLiteDAO();
        cidadeDAO.save(cidade1);
        cidadeDAO.save(cidade2);

        Aluno a1 = new Aluno(1,"1111","Maria",curso1,cidade1);
        Aluno a2 = new Aluno(2,"2222","João",curso2,cidade2);

        AlunoSQLiteDAO alunoDAO = new AlunoSQLiteDAO();
        //Outra forma de instanciar o DAO:
        //DAO<Aluno> alunoDAO = new AlunoSQLiteDAO();

        alunoDAO.save(a1);
        alunoDAO.save(a2);


        List<Curso> listaCursos=cursoDAO.findAll();
        for (Curso c : listaCursos )
            System.out.println(c);

        List<Cidade> listaCidades=cidadeDAO.findAll();
        for (Cidade c : listaCidades )
            System.out.println(c);

        List<Aluno> listaAlunos=alunoDAO.findAll();
        for (Aluno a : listaAlunos )
            System.out.println(a);

    }
}
