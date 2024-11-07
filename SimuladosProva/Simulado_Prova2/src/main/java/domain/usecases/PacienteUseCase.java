package domain.usecases;

import domain.entity.Especialidade;
import domain.entity.Paciente;
import domain.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

public class PacienteUseCase {
    private final PacienteRepository repository;

    public PacienteUseCase(PacienteRepository repository) {
        this.repository = repository;
    }

    public void save(Paciente paciente){
        repository.save(paciente);
    }


    public Optional<Paciente> findById(int id){
        return repository.findById(id);
    }

    public List<Paciente> findAll(){
        return  repository.findAll();
    }

}
