package data.dao;

import model.Doacao;
import model.Doador;

import java.util.List;

public interface DoacaoDAO extends DAO<Doacao>{
    List<Doacao> findByDoador(Doador doador);
}
