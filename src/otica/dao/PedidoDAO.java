package otica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import otica.factory.ConnectionFactory;
import otica.model.Pedido;

public class PedidoDAO {
	
	public void save(Pedido pedido) {
		
		String sql = "INSERT INTO pedido(ClienteID, ProdutoID, ValorTotal, metodo_pagamento) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getClienteID());
			pstm.setInt(2, pedido.getProdutoID());
			pstm.setDouble(3, pedido.getValorTotal());
			pstm.setString(4, pedido.getMetodo_pagamento());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	public void update(Pedido pedido) {
		
		String sql = "UPDATE pedido SET ClienteID = ?, ProdutoID = ?, ValorTotal = ?, metodo_pagamento = ?" + "WHERE PedidoID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getClienteID());
			pstm.setInt(2, pedido.getProdutoID());
			pstm.setDouble(2, pedido.getValorTotal());
			pstm.setString(3, pedido.getMetodo_pagamento());
			
			pstm.setInt(4, pedido.getPedidoID());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int PedidoID) {
		String sql = "DELETE FROM pedido WHERE PedidoID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, PedidoID);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Pedido> getPedidos(){
		String sql = "SELECT * FROM pedido";
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Pedido pedido = new Pedido();
				
				pedido.setPedidoID(rset.getInt("PedidoID"));
				pedido.setClienteID(rset.getInt("ClienteID"));
				pedido.setClienteID(rset.getInt("ProdutoID"));
				pedido.setValorTotal(rset.getDouble("ValorTotal"));
				pedido.setMetodo_pagamento(rset.getString("metodo_pagamento"));
				
				pedidos.add(pedido);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pedidos;
	}

	
}
