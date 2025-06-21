package otica.controllers;

import java.util.List;
import otica.dao.FuncionarioDAO;
import otica.model.Funcionario;

public class FuncionarioController {
    
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
    }

    public void deletarFuncionario(int funcionarioID) {
        funcionarioDAO.delete(funcionarioID);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.getFuncionarios();
    }

}
