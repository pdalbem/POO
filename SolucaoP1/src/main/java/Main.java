import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cidade cidade1 = new Cidade("São Carlos", "SP");

        Especialidade especialidade1 = new Especialidade(1,"Cardiologista");

        Medico medico1 = new Medico("1234", "Joaquim", cidade1, "1414", especialidade1);
        Medico medico2 = new Medico("4321", "Maria", cidade1, "1314", especialidade1);

        especialidade1.adicionarMedico(medico1);
        especialidade1.adicionarMedico(medico2);

        Paciente paciente1 = new Paciente("111", "José", cidade1, "3333");
        Paciente paciente2 = new Paciente("121", "Joaquina", cidade1, "33333");

        cidade1.adicionarPessoa(medico1,medico2,paciente1,paciente2);

        Consulta consulta1 = new Consulta(LocalDate.of(2024, 9, 26), LocalTime.of(14, 30), 300,paciente1, medico1);
        Consulta consulta2 = new Consulta(LocalDate.of(2024, 9, 26), LocalTime.of(15, 30), 300, paciente2, medico2);

        paciente1.adicionarConsulta(consulta1);
        paciente2.adicionarConsulta(consulta2);

       for (Medico m: especialidade1.getMedicos())
           System.out.println(m.obterDados());

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(paciente1);
        pessoas.add(paciente2);
        pessoas.add(medico1);
        pessoas.add(medico2);

        for (Pessoa pessoa: pessoas){
            System.out.println(pessoa.obterDados());
        }
    }
}