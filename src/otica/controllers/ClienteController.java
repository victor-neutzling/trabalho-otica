package otica.controllers;

import java.util.List;
import otica.dao.ClienteDAO;
import otica.model.Cliente;

public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    // Criar (salvar) um novo cliente
    public void salvarCliente(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    // Atualizar dados de um cliente existente
    public void atualizarCliente(Cliente cliente) {
        clienteDAO.update(cliente);
    }

    // Deletar cliente pelo ID
    public void deletarCliente(int clienteID) {
        clienteDAO.delete(clienteID);
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteDAO.getClientes();
    }
}
