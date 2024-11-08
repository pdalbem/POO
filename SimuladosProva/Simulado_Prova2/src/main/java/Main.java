import adapters.dao.*;
import adapters.repository.ConsultaRepositoryImpl;
import adapters.repository.EspecialidadeRepositoryImpl;
import adapters.repository.MedicoRepositoryImpl;
import adapters.repository.PacienteRepositoryImpl;
import domain.entity.Consulta;
import domain.entity.Especialidade;
import domain.entity.Medico;
import domain.entity.Paciente;
import domain.repository.ConsultaRepository;
import domain.repository.EspecialidadeRepository;
import domain.repository.MedicoRepository;
import domain.repository.PacienteRepository;
import domain.usecases.ConsultaUseCase;
import domain.usecases.EspecialidadeUseCase;
import domain.usecases.MedicoUseCase;
import domain.usecases.PacienteUseCase;

public class Main {
    public static void main(String[] args) {
        /////////////////////////////////////////////////////
        // Config, do DAO, Repository e UseCase
        /////////////////////////////////////////////////////
        EspecialidadeDAO especialidadeDAO=new EspecialidadeDAOImpl();
        EspecialidadeRepository especialidadeRepository=new EspecialidadeRepositoryImpl(especialidadeDAO);
        EspecialidadeUseCase especialidadeUseCase=new EspecialidadeUseCase(especialidadeRepository);

        PacienteDAO pacienteDAO=new PacienteDAOImpl();
        PacienteRepository pacienteRepository=new PacienteRepositoryImpl(pacienteDAO);
        PacienteUseCase pacienteUseCase=new PacienteUseCase(pacienteRepository);

        MedicoDAO medicoDAO=new MedicoDAOImpl();
        MedicoRepository medicoRepository=new MedicoRepositoryImpl(medicoDAO);
        MedicoUseCase medicoUseCase=new MedicoUseCase(medicoRepository);

        ConsultaDAO consultaDAO=new ConsultaDAOImpl();
        ConsultaRepository consultaRepository=new ConsultaRepositoryImpl(consultaDAO);
        ConsultaUseCase consultaUseCase=new ConsultaUseCase(consultaRepository);

        /////////////////////////////////////////////////////
        // Especialidade
        /////////////////////////////////////////////////////
        Especialidade especialidade1=new Especialidade("Cardiologia");
        Especialidade especialidade2=new Especialidade("Ortopedista");
        especialidadeUseCase.save(especialidade1);
        especialidadeUseCase.save(especialidade2);

        /////////////////////////////////////////////////////
        // Médico
        /////////////////////////////////////////////////////
        Medico medico1 = new Medico("Joaqum","CRM123", especialidade1);
        Medico medico2 = new Medico("Maria", "CRM1212", especialidade2);
        medicoUseCase.save(medico1);
        medicoUseCase.save(medico2);

        /////////////////////////////////////////////////////
        // Paciente
        /////////////////////////////////////////////////////
        Paciente paciente = new Paciente("João","1234-4321");
        pacienteUseCase.save(paciente);

        /////////////////////////////////////////////////////
        // Consulta
        /////////////////////////////////////////////////////
        Consulta consulta1 = new Consulta("01/01/2024","8:00",paciente,medico1);
        Consulta consulta2 = new Consulta("10/11/2024","15h00",paciente,medico2);
        consultaUseCase.save(consulta1);
        consultaUseCase.save(consulta2);

        /////////////////////////////////////////////////////
        // Leitura do BD
        /////////////////////////////////////////////////////
        for (Especialidade e: especialidadeUseCase.findAll())
            System.out.println(e);

        for (Medico m: medicoUseCase.findAll())
            System.out.println(m);

        for (Paciente p: pacienteUseCase.findAll())
            System.out.println(p);

        for (Medico m:medicoUseCase.findByEspecialidade(especialidade1))
            System.out.println(m);

        for (Consulta c: consultaUseCase.findAll())
            System.out.println(c);

        for (Consulta c: consultaUseCase.findByPaciente(paciente))
            System.out.println(c);

    }
}
