package otica.model;

public class Pedido {
	
	private int PedidoID;
	private int ClienteID;
	private double ValorTotal;
	private String metodo_pagamento;
	
	public int getPedidoID() {
		return PedidoID;
	}
	public void setPedidoID(int pedidoID) {
		PedidoID = pedidoID;
	}
	public int getClienteID() {
		return ClienteID;
	}
	public void setClienteID(int clienteID) {
		ClienteID = clienteID;
	}
	public double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}
	public String getMetodo_pagamento() {
		return metodo_pagamento;
	}
	public void setMetodo_pagamento(String metodo_pagamento) {
		this.metodo_pagamento = metodo_pagamento;
	}
	
}
