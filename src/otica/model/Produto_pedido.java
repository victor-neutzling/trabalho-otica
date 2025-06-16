package otica.model;

public class Produto_pedido {
	
	private int ProdutoPedidoID;
	private int ProdutoID;
	private int PedidoID;
	
	public int getProdutoPedidoID() {
		return ProdutoPedidoID;
	}
	public void setProdutoPedidoID(int produtoPedidoID) {
		ProdutoPedidoID = produtoPedidoID;
	}
	public int getProdutoID() {
		return ProdutoID;
	}
	public void setProdutoID(int produtoID) {
		ProdutoID = produtoID;
	}
	public int getPedidoID() {
		return PedidoID;
	}
	public void setPedidoID(int pedidoID) {
		PedidoID = pedidoID;
	}
	
}
