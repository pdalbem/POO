package usecase;

import domain.entity.Curso;
import domain.exception.EntityAlreadyExistsException;
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
        // Verifica se já existe curso com mesmo nome
        Iterator<Curso> existentes = cursoRepo.findByName(curso.getNome());
        if (existentes.hasNext()) {
            throw new EntityAlreadyExistsException(
                    "Já existe um curso com o nome: " + curso.getNome()
            );
        }

        this.cursoRepo.save(curso);
    }

    public void updateCurso(Curso curso) {
        // Verificar se existe antes de atualizar
        Optional<Curso> existente = cursoRepo.findById(curso.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException(
                    "Curso com id " + curso.getId() + " não encontrado."
            );
        }

        this.cursoRepo.update(curso);
    }

    public void deleteCurso(Curso curso) {
        // Verificar se existe antes de apagar
        Optional<Curso> existente = cursoRepo.findById(curso.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException(
                    "Curso com id " + curso.getId() + " não encontrado."
            );
        }

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

