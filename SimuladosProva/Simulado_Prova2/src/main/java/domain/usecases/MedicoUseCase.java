package domain.usecases;

import domain.entity.Especialidade;
import domain.entity.Medico;
import domain.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

public class MedicoUseCase {
    private final MedicoRepository repository;

    public MedicoUseCase(MedicoRepository repository) {
        this.repository = repository;
    }

    public void save(Medico medico){
        repository.save(medico);
    }

    public Optional<Medico> findById(int id){
        return repository.findById(id);
    }

    public List<Medico> findAll(){
        return  repository.findAll();
    }

    public List<Medico> findByEspecialidade(Especialidade especialidade){
        return  repository.findByEspecialidade(especialidade);
    }

}
