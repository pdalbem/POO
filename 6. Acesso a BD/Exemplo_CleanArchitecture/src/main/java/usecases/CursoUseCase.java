package usecases;

import adapters.repository.CursoRepository;
import domain.entity.Curso;
import domain.repository.Repository;

import java.util.List;
import java.util.Optional;

public class CursoUseCase {
    private final CursoRepository repository;

    public CursoUseCase(CursoRepository repository) {
        this.repository = repository;
    }

    public void addCurso(Curso c){
         repository.save(c);
    }

    public void updateCurso(Curso c){
        repository.update(c);
    }

    public void deleteCurso(Curso c){
        repository.delete(c);
    }

    public Optional<Curso> getCursoById(int id){
        return repository.findById(id);
    }

    public List<Curso> getAllCursos(){
       return  repository.findAll();
    }

    public  Optional<Curso> getCursoByName(String name){return repository.findByName(name);}


}
