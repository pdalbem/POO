package usecase;

import domain.entity.Curso;
import domain.repository.CursoRepository;

import java.util.Iterator;
import java.util.Optional;

public class CursoUseCase {
    private final CursoRepository cursoRepo; // depende da abstração e não da classe concreta (princípio da inversão de dependência - DIP)

    //injeção de dependência via construtor
    public CursoUseCase(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    public void insertCurso(Curso curso) {
        this.cursoRepo.save(curso);
    }

    public void updateCurso(Curso curso) {
        this.cursoRepo.update(curso);
    }

    public void deleteCurso(Curso curso) {
        this.cursoRepo.delete(curso);
    }

    public Optional<Curso> findCursoById(int id) {
        return this.cursoRepo.findById(id);
    }

    public Iterator<Curso> findCursoByName(String name) {
        return this.cursoRepo.findByName(name);
    }

    public Iterator<Curso> listAllCursos() {
        return this.cursoRepo.findAll();
    }
}

