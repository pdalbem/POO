package domain.usecases;

import domain.repository.CidadeRepository;
import domain.entity.Cidade;

import java.util.List;
import java.util.Optional;

public class CidadeUseCase {
    private final CidadeRepository repository;

    public CidadeUseCase(CidadeRepository repository) {
        this.repository = repository;
    }

    public void addCidade(Cidade c){
         repository.save(c);
    }

    public void updateCidade(Cidade c){
        repository.update(c);
    }

    public void deleteCidade(Cidade c){
        repository.delete(c);
    }

    public Optional<Cidade> getCidadeById(int id){
        return repository.findById(id);
    }

    public List<Cidade> getAllCidades(){
        return  repository.findAll();
    }
}
