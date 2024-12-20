package domain.usecases;

import domain.repository.AlunoRepository;
import domain.entity.Aluno;

import java.util.List;
import java.util.Optional;

public class AlunoUseCase {
    private final AlunoRepository repository;

    public AlunoUseCase(AlunoRepository repository) {
        this.repository = repository;
    }

    public void addAluno(Aluno c){
         repository.save(c);
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

    public Optional<Aluno> getAlunoByProntuario(String prontuario){
        return repository.findByProntuario(prontuario);
    }
}
