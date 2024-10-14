package usecases;

import domain.Curso;
import adapters.Repository;

import java.util.List;
import java.util.Optional;

public class CursoUseCase {
    private final Repository<Curso> repository;

    public CursoUseCase(Repository<Curso> repository) {
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


}
