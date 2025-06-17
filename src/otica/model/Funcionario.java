package otica.model;

public class Funcionario {

	private int FuncionarioID;
	private String nome;
	private String cpf;
	private String cargo;

	public int getFuncionarioID() {
		return FuncionarioID;
	}
	public void setFuncionarioID(int funcionarioID) {
		FuncionarioID = funcionarioID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}