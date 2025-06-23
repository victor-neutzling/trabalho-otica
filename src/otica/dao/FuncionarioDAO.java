package otica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import otica.factory.ConnectionFactory;
import otica.model.Funcionario;

public class FuncionarioDAO {

	public void save(Funcionario funcionario) {
		
		String sql = "INSERT INTO funcionario(nome, cpf, cargo, salario) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			pstm.setString(3, funcionario.getCargo());
			pstm.setDouble(4, funcionario.getSalario());
			
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

	public void update(Funcionario funcionario) {
		
		String sql = "UPDATE funcionario SET nome = ?, cpf = ?, cargo = ?, salario = ?" + "WHERE FuncionarioID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			pstm.setString(3, funcionario.getCargo());
			pstm.setDouble(4, funcionario.getSalario());
			
			pstm.setInt(5, funcionario.getFuncionarioID());
			
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
	
	public void delete(int FuncionarioID) {
		String sql = "DELETE FROM funcionario WHERE FuncionarioID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, FuncionarioID);
			
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
	
	public List<Funcionario> getFuncionarios(){
		String sql = "SELECT * FROM funcionario";
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setFuncionarioID(rset.getInt("FuncionarioID"));
				funcionario.setNome(rset.getString("nome"));
				funcionario.setCpf(rset.getString("cpf"));
				funcionario.setCargo(rset.getString("cargo"));
				funcionario.setSalario(rset.getDouble("salario"));
				
				
				funcionarios.add(funcionario);
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
		
		return funcionarios;
	}

}
