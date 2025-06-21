package otica.main;

import otica.controllers.ClienteController;
import otica.controllers.FuncionarioController;
import otica.controllers.ProdutoController;
import otica.model.Cliente;
import otica.model.Funcionario;
import otica.model.Produto;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CLIENTE
        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();
        cliente.setNome("João da Silva");
        cliente.setCpf("123.456.789-00");
        clienteController.salvarCliente(cliente);
        System.out.println("Cliente adicionado!");

        List<Cliente> clientes = clienteController.listarClientes();
        System.out.println("Clientes cadastrados:");
        for (Cliente c : clientes) {
            System.out.println(c.getClienteID() + " - " + c.getNome() + " - " + c.getCpf());
        }

        System.out.println("------------------------------------------------");

        // PRODUTO
        ProdutoController produtoController = new ProdutoController();
        Produto produto = new Produto();
        produto.setNome("Óculos de Sol");
        produto.setDescricao("Lente polarizada");
        produto.setPreco(199.99);
        produtoController.salvarProduto(produto);
        System.out.println("Produto adicionado!");

        List<Produto> produtos = produtoController.listarProdutos();
        System.out.println("Produtos cadastrados:");
        for (Produto p : produtos) {
            System.out.println(p.getProdutoID() + " - " + p.getNome() + " - R$" + p.getPreco());
        }

        System.out.println("------------------------------------------------");

        // FUNCIONÁRIO
        FuncionarioController funcionarioController = new FuncionarioController();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Ana Paula");
        funcionario.setCpf("987.654.321-00");
        funcionario.setCargo("Gerente");
        funcionarioController.adicionarFuncionario(funcionario);
        System.out.println("Funcionário adicionado!");

        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        System.out.println("Funcionários cadastrados:");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getFuncionarioID() + " - " + f.getNome() + " - " + f.getCargo());
        }
    }
}
