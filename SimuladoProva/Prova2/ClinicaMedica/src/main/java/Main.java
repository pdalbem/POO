import java.time.LocalDateTime;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Especialidade cardiologia = new Especialidade("Cardiologia");
            Especialidade ortopedia = new Especialidade("Ortopedia");
            System.out.println(cardiologia);
            System.out.println(ortopedia);

            Medico medico1 = new Medico("12345678900", "Dra. Ana", "CRM123", cardiologia);
            medico1.exibirInfo();

            Medico medico2 = new Medico("22222222222", "Dr. Joaquim", "CRM444", ortopedia);
            medico2.exibirInfo();

            Paciente paciente1 = new Paciente("98765432100", "João Silva", "99999-0000");
            paciente1.exibirInfo();

            Consulta consulta1 = new Consulta(LocalDateTime.of(2025, 5, 10, 14, 0),
                    medico1, paciente1);

            consulta1.exibirInfo();
            consulta1.confirmarConsulta();

            consulta1.remarcarConsulta(LocalDateTime.of(2025, 5, 10, 14, 30));
            consulta1.exibirInfo();

            Consulta consulta2 = new Consulta(LocalDateTime.of(2025, 5, 10, 15, 0),
                    medico1, paciente1);
            consulta2.confirmarConsulta();

            consulta1.cancelarConsulta();
            consulta1.exibirInfo();

            System.out.println("Consultas do paciente:");
            Iterator<Consulta> consultaIterator = paciente1.obterConsultas();
            while (consultaIterator.hasNext()) {
                Consulta next =  consultaIterator.next();
                next.exibirInfo();
            }

            System.out.println("Consultas do paciente no período 01/05/2025 a 31/05/2025:");
            consultaIterator = paciente1.obterConsultas(LocalDateTime.of(2025,5,1,0,0),
                    LocalDateTime.of(2025,5,31,23,59));
            while (consultaIterator.hasNext()) {
                Consulta next =  consultaIterator.next();
                next.exibirInfo();
            }

            System.out.println("Consultas do paciente ao médico "+medico1.getNome());
            consultaIterator = paciente1.obterConsultas(medico1);
            while (consultaIterator.hasNext()) {
                Consulta next =  consultaIterator.next();
                next.exibirInfo();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
