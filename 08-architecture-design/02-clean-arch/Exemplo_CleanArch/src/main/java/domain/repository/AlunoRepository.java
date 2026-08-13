package domain.repository;

import domain.entity.Aluno;

import java.util.Optional;

public interface AlunoRepository extends Repository<Aluno> {
    Optional<Aluno> findByProntuario(String prontuario);
}
