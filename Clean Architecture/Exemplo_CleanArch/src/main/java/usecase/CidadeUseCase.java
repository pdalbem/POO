package usecase;

import domain.entity.Cidade;
import domain.repository.CidadeRepository;

import java.util.Iterator;
import java.util.Optional;

public class CidadeUseCase {
    private final CidadeRepository cidadeRepo; // depende da abstração e não da classe concreta (princípio da inversão de dependência - DIP)

    //injeção de dependência via construtor
    public CidadeUseCase(CidadeRepository cidadeRepo) {
        this.cidadeRepo = cidadeRepo;
    }

    public void insertCidade(Cidade cidade) {
        this.cidadeRepo.save(cidade);
    }

    public void updateCidade(Cidade cidade) {
        this.cidadeRepo.update(cidade);
    }

    public void deleteCidade(Cidade cidade) {
        this.cidadeRepo.delete(cidade);
    }

    public Optional<Cidade> findCidadeById(int id) {
        return this.cidadeRepo.findById(id);
    }

    public Iterator<Cidade> listAllCidades() {
        return this.cidadeRepo.findAll();
    }
}
