package org.example.exemplo_javafx.application;


import org.example.exemplo_javafx.domain.model.Produto;
import org.example.exemplo_javafx.infrastructure.dao.ProdutoDAO;

import java.util.List;

public class ProdutoService {
    private final ProdutoDAO dao = new ProdutoDAO();

    public void salvar(Produto p) {
        dao.salvar(p);
    }

    public void atualizar(Produto p) {
        dao.atualizar(p);
    }

    public void remover(int id) {
        dao.remover(id);
    }

    public List<Produto> listarTodos() {
        return dao.listarTodos();
    }
}