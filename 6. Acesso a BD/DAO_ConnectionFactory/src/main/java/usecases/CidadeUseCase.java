package usecases;

import domain.Cidade;
import domain.Curso;
import interfaces.Repository;

import java.util.List;
import java.util.Optional;

public class CidadeUseCase {
    private final Repository<Cidade> repository;

    public CidadeUseCase(Repository<Cidade> repository) {
        this.repository = repository;
    }

    public int addCidade(Cidade c){
        return repository.save(c);
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