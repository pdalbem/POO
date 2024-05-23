import data.DAO;
import data.DepartamentoSQLiteDAO;
import data.FuncionarioSQLIteDAO;
import model.Departamento;
import model.Funcionario;

public class Main {
    public static void main(String[] args) {
        Departamento d1 = new Departamento(1,"Tecnologia da Informação", "TI");
        Departamento d2 = new Departamento(2,"Recursos Humanos","RH");

        DepartamentoSQLiteDAO departamentoSQLiteDAO=new DepartamentoSQLiteDAO();
        departamentoSQLiteDAO.save(d1);
        departamentoSQLiteDAO.save(d2);

        Funcionario f1 = new Funcionario(10,"123456", "Maria",d1);

        FuncionarioSQLIteDAO funcionarioSQLIteDAO=new FuncionarioSQLIteDAO();
       funcionarioSQLIteDAO.save(f1);

        Funcionario f2=funcionarioSQLIteDAO.findById(10);
        System.out.println(f2);

        for (Departamento d: departamentoSQLiteDAO.findAll())
            System.out.println(d);

        for (Funcionario f: funcionarioSQLIteDAO.findAll())
            System.out.println(f);



    }
}
