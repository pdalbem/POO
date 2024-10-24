package adapters.repository;

import domain.entity.Aluno;
import domain.repository.Repository;

import java.util.Optional;

public interface AlunoRepository extends Repository<Aluno> {
    Optional<Aluno> findByProntuario(String prontuario);
}
