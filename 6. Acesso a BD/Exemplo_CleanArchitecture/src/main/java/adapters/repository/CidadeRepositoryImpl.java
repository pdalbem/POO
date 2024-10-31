package adapters.repository;

import adapters.dao.CidadeDAO;
import domain.entity.Cidade;
import domain.repository.CidadeRepository;

import java.util.List;
import java.util.Optional;

public class CidadeRepositoryImpl implements CidadeRepository {
    private final CidadeDAO dao;

    public CidadeRepositoryImpl(CidadeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Cidade cidade) {

        int id= dao.save(cidade);
        cidade.setIdCidade(id);
    }

    @Override
    public void update(Cidade cidade) {
        dao.update(cidade);
    }

    @Override
    public void delete(Cidade cidade) {
        dao.delete(cidade);
    }

    @Override
    public Optional<Cidade> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Cidade> findAll() {
        return dao.findAll();
    }
}
