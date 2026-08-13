package usecase;

import domain.entity.Proprietario;
import domain.exception.EntityAlreadyExistsException;
import domain.repository.ProprietarioRepository;

import java.util.Iterator;
import java.util.Optional;

public class ProprietarioUseCase {
    private final ProprietarioRepository proprietarioRepo;

    public ProprietarioUseCase(ProprietarioRepository proprietarioRepo) {
        this.proprietarioRepo = proprietarioRepo;
    }

    public void insertProprietario(Proprietario proprietario) {
        proprietarioRepo.save(proprietario);
    }

    public Optional<Proprietario> findProprietarioById(int id) {
        return proprietarioRepo.findById(id);
    }

    public Iterator<Proprietario> listAllProprietarios() {
        return proprietarioRepo.findAll();
    }
}

