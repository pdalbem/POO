package service;


import data.dao.AlunoDAO;
import exception.EntityNotFoundException;
import model.Aluno;

import java.util.List;
import java.util.Optional;

public class AlunoService {

    private final AlunoDAO alunoDAO;

    public AlunoService(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Aluno cadastrar(Aluno aluno) {
        if (aluno == null)
            throw new IllegalArgumentException("O aluno não pode ser nulo." );

        return alunoDAO.save(aluno);
    }

    public void atualizar(Aluno aluno) {
        if (aluno == null)
            throw new IllegalArgumentException("O aluno não pode ser nulo.");

        int linhasAfetadas = alunoDAO.update(aluno);
        if (linhasAfetadas == 0)
            throw new EntityNotFoundException("Aluno não encontrado: " + aluno.getProntuario() );
    }

    public void excluir(int id) {
        if (id <= 0)
            throw new IllegalArgumentException( "O ID do aluno deve ser positivo." );

        int linhasAfetadas = alunoDAO.delete(id);
        if (linhasAfetadas == 0)
            throw new EntityNotFoundException("Aluno não encontrado: " + id );
    }

    public Optional<Aluno> buscarPorId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException( "O ID do aluno deve ser positivo." );

        return alunoDAO.findById(id);
    }

    public Optional<Aluno> buscarPorProntuario(String prontuario) {
        if (prontuario == null || prontuario.isBlank())
            throw new IllegalArgumentException( "O prontuário não pode ser vazio.");

        return alunoDAO.findByProntuario(prontuario);
    }

    public List<Aluno> buscarTodos() {
        return alunoDAO.findAll();
    }
}
