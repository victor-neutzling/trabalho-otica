package otica.main;

import otica.dao.ProdutoDAO;
import otica.model.Produto;

public class Main {

	public static void main(String[] args) {
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		Produto p = new Produto();
		
		p.setNome("oculos 1");
		p.setDescricao("lorem ipsum");
		p.setPreco(12.99);
		
		produtoDao.save(p);
		
		//teste teste
		
		for(Produto p1 : produtoDao.getProdutos()) {
			System.out.println(p1.getNome());
		}
	}

}
