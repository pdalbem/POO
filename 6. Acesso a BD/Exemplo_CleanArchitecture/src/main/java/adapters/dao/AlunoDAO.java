package adapters.dao;

import domain.entity.Aluno;


import java.util.Optional;

public interface AlunoDAO extends DAO<Aluno> {
    Optional<Aluno> findByProntuario(String prontuario);
}
