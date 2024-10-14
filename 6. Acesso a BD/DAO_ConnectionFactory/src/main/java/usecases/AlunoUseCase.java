package usecases;

import domain.Aluno;
import adapters.Repository;

import java.util.List;
import java.util.Optional;

public class AlunoUseCase {
    private final Repository<Aluno> repository;

    public AlunoUseCase(Repository<Aluno> repository) {
        this.repository = repository;
    }

    public int addAluno(Aluno c){
        return repository.save(c);
    }

    public void updateAluno(Aluno c){
        repository.update(c);
    }

    public void deleteAluno(Aluno c){
        repository.delete(c);
    }

    public Optional<Aluno> getAlunoById(int id){
        return repository.findById(id);
    }

    public List<Aluno> getAllAlunos(){
        return  repository.findAll();
    }
}
