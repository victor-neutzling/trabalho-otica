package otica.model;

public class Produto {
	
	private int ProdutoID;
	private String Nome;
	private String Descricao;
	private double Preco;
	
	public int getProdutoID() {
		return ProdutoID;
	}
	public void setProdutoID(int produtoID) {
		ProdutoID = produtoID;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
	}
	
}
