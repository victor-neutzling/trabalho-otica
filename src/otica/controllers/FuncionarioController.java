package otica.controllers;

import java.util.List;
import otica.dao.FuncionarioDAO;
import otica.model.Funcionario;

public class FuncionarioController {
    
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
    }

    // Método usado para salvar funcionário
    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    // Atualizar funcionário
    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
    }

    // Deletar funcionário por ID
    public void deletarFuncionario(int funcionarioID) {
        funcionarioDAO.delete(funcionarioID);
    }

    // Listar todos os funcionários
    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.getFuncionarios();
    }
    
    public Funcionario getFuncionarioByCPF(String cpf) {
    	List<Funcionario> funcionarios = this.listarFuncionarios();
    	Funcionario funcionarioFinal = new Funcionario();
    	
    	for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionarioFinal = funcionario;
                break; 
            }
        }
    	
    	return funcionarioFinal;
    }
    
    public boolean login(String cpf) {
    	Funcionario funcionarioLogado = this.getFuncionarioByCPF(cpf);
    	
    	return funcionarioLogado.getCpf() != null;
    }
}
