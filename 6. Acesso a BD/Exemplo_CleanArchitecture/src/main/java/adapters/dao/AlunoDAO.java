package adapters.dao;

import domain.entity.Aluno;
import domain.entity.Curso;

import java.util.Optional;

public interface AlunoDAO extends DAO<Aluno> {
    Optional<Aluno> findByProntuario(String prontuario);
}
