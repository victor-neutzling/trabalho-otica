package otica.controllers;

import otica.dao.PedidoDAO;
import otica.model.Pedido;

public class PedidoController {
	
	private PedidoDAO pedidoDAO = new PedidoDAO();
	
	public void cadastrarPedido(Pedido pedido) {
		pedidoDAO.save(pedido);
	}
}
