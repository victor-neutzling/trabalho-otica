package otica.controllers;

import java.util.List;
import otica.dao.ProdutoDAO;
import otica.model.Produto;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void salvarProduto(Produto produto) {
        produtoDAO.save(produto);
    }

    public void atualizarProduto(Produto produto) {
        produtoDAO.update(produto);
    }

    public void excluirProduto(int produtoID) {
        produtoDAO.delete(produtoID);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.getProdutos();
    }
}
