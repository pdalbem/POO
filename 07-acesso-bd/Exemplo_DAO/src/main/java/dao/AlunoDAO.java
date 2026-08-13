package dao;

import model.Aluno;

import java.util.Optional;

public interface AlunoDAO extends DAO<Aluno>{
    Optional<Aluno> findByProntuario(String prontuario);
}
