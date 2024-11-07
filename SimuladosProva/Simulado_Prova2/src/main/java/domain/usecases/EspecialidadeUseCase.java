package domain.usecases;

import domain.entity.Especialidade;
import domain.repository.EspecialidadeRepository;

import java.util.List;
import java.util.Optional;

public class EspecialidadeUseCase {
    private  final EspecialidadeRepository repository;

    public EspecialidadeUseCase(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    public void save(Especialidade especialidade){
        repository.save(especialidade);
    }

    public void update(Especialidade especialidade){
        repository.update(especialidade);
    }

    public void delete(Especialidade especialidade){
        repository.delete(especialidade);
    }

    public Optional<Especialidade> findById(int id){
        return repository.findById(id);
    }

    public List<Especialidade> findAll(){
        return  repository.findAll();
    }

}
