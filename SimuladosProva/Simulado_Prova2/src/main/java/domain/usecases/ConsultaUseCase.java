package domain.usecases;

import domain.entity.Consulta;
import domain.entity.Paciente;
import domain.repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;

public class ConsultaUseCase {
    private final ConsultaRepository repository;

    public ConsultaUseCase(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void save(Consulta consulta){
        repository.save(consulta);
    }

    public Optional<Consulta> findById(int id){
        return repository.findById(id);
    }

    public List<Consulta> findAll(){
        return  repository.findAll();
    }

    public List<Consulta> findByPaciente(Paciente paciente){
        return  repository.findByPaciente(paciente);
    }
}
