package usecase;

import domain.entity.Aluno;
import domain.exception.EntityAlreadyExistsException;
import domain.repository.AlunoRepository;

import java.util.Iterator;
import java.util.Optional;

public class AlunoUseCase {
    private final AlunoRepository alunoRepo; // depende da abstração e não da classe concreta (princípio da inversão de dependência - DIP)

    //injeção de dependência via construtor
    public AlunoUseCase(AlunoRepository alunoRepo) {
        this.alunoRepo = alunoRepo;
    }

    public void insertAluno(Aluno aluno){
        Optional<Aluno> existente = alunoRepo.findByProntuario(aluno.getProntuario());
        if (existente.isPresent()) {
            throw new EntityAlreadyExistsException("Já existe um aluno com esse prontuário: " + aluno.getProntuario());
        }
        this.alunoRepo.save(aluno);
    }

    public void updateAluno(Aluno aluno){
        // Verifica se o ID existe antes de atualizar
        Optional<Aluno> existente = alunoRepo.findById(aluno.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException(
                    "Não existe aluno com id " + aluno.getId()
            );
        }
        this.alunoRepo.update(aluno);
    }

    public void deleteAluno(Aluno aluno){
        // Verifica se o ID existe antes de deletar
        Optional<Aluno> existente = alunoRepo.findById(aluno.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException(
                    "Não existe aluno com id " + aluno.getId()
            );
        }
        this.alunoRepo.delete(aluno);
    }

    public Optional<Aluno> findAlunoById(int id){
        return this.alunoRepo.findById(id);
    }

    public Optional<Aluno> findAlunoByProntuario(String prontuario){
        return this.alunoRepo.findByProntuario(prontuario);
    }

    public Iterator<Aluno> listAllAlunos(){
        return this.alunoRepo.findAll();
    }

}
