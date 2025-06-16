package otica.model;

public class Cliente {
	
	private int ClienteID;
	private String Nome;
	private String Cpf;
	
	public int getClienteID() {
		return ClienteID;
	}
	public void setClienteID(int clienteID) {
		ClienteID = clienteID;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	
}
