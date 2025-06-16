package otica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import otica.factory.ConnectionFactory;
import otica.model.Produto_pedido;

public class ProdutoPedidoDAO {
	
	public void save(Produto_pedido produtoPedido) {
		
		String sql = "INSERT INTO produto_pedido(ProdutoID, PedidoID) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, produtoPedido.getProdutoID());
			pstm.setInt(2, produtoPedido.getPedidoID());
		
			
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
	
	public void update(Produto_pedido produtoPedido) {
		
		String sql = "UPDATE produto_pedido SET PedidoID = ?, ProdutoID = ?" + "WHERE ProdutoID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, produtoPedido.getProdutoID());
			pstm.setInt(2, produtoPedido.getPedidoID());
			
			pstm.setInt(3, produtoPedido.getProdutoPedidoID());
			
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
	
	public void delete(int ProdutoPedidoID) {
		String sql = "DELETE FROM produto_pedido WHERE ProdutoPedidoID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, ProdutoPedidoID);
			
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
	
	public List<Produto_pedido> getProdutoPedidos(){
		String sql = "SELECT * FROM produto_pedido";
		
		List<Produto_pedido> produto_pedidos = new ArrayList<Produto_pedido>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Produto_pedido produtoPedido = new Produto_pedido();
				
				produtoPedido.setProdutoPedidoID(rset.getInt("ProdutoPedidoID"));
				produtoPedido.setProdutoID(rset.getInt("ProdutoID"));
				produtoPedido.setPedidoID(rset.getInt("PedidoID"));
				
				produto_pedidos.add(produtoPedido);
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
		
		return produto_pedidos;
	}

	
}
