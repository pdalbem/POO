package frameworks;

import domain.Cidade;
import domain.Curso;
import interfaces.DAO;
import interfaces.Repository;

import java.util.List;
import java.util.Optional;

public class CidadeRepository implements Repository<Cidade> {
    private final DAO<Cidade> dao;

    public CidadeRepository(DAO<Cidade> dao) {
        this.dao = dao;
    }

    @Override
    public int save(Cidade cidade) {
        return dao.save(cidade);
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
