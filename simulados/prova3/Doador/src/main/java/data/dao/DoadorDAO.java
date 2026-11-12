package data.dao;

import model.Doador;
import model.TipoSanguineo;

import java.util.List;

public interface DoadorDAO extends DAO<Doador>{
    int update(Doador doador);
    List<Doador> findByTipoSanguineo(TipoSanguineo tipoSanguineo);
    List<Doador> findDoadoresAptos();
}
