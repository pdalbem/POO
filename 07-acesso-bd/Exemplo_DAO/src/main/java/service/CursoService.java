package service;

import data.dao.CursoDAO;
import exception.EntityNotFoundException;
import model.Curso;

import java.util.List;
import java.util.Optional;

public class CursoService {
    private final CursoDAO cursoDAO;

    public CursoService(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public Curso cadastrar(Curso curso) {
        if (curso == null)
            throw new IllegalArgumentException("O curso não pode ser nulo.");

        return cursoDAO.save(curso);
    }

    public void atualizar(Curso curso) {
        if (curso == null)
            throw new IllegalArgumentException("O curso não pode ser nulo.");

        int linhasAfetadas = cursoDAO.update(curso);
        if (linhasAfetadas == 0)
            throw new EntityNotFoundException("Curso não encontrado: " + curso.getNome());
    }

    public void excluir(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("O ID do curso deve ser positivo.");

        int linhasAfetadas = cursoDAO.delete(id);
        if (linhasAfetadas == 0)
            throw new EntityNotFoundException("Curso não encontrado");
    }

    public Optional<Curso> buscarPorId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("O ID do curso deve ser positivo." );

        return cursoDAO.findById(id);
    }

    public List<Curso> buscarPorNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome para busca não pode ser vazio.");

        return cursoDAO.findByNome(nome);
    }

    public List<Curso> buscarTodos() {
        return cursoDAO.findAll();
    }
}
