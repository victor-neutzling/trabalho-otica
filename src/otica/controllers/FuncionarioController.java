package otica.controllers;

import java.util.List;
import otica.dao.FuncionarioDAO;
import otica.model.Funcionario;

public class FuncionarioController {
    
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
    }

    // Método usado para salvar funcionário (equivalente a adicionar)
    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    // Método alternativo com nome diferente, mas mesma funcionalidade
    public void adicionarFuncionario(Funcionario funcionario) {
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
}
