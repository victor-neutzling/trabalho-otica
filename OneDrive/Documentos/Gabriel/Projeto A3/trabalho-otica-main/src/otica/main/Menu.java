package otica.main;

import java.util.Scanner;

import otica.controllers.ClienteController;
import otica.controllers.FuncionarioController;
import otica.controllers.ProdutoController;
import otica.model.Cliente;
import otica.model.Funcionario;
import otica.model.Produto;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        FuncionarioController funcionarioController = new FuncionarioController();
        ProdutoController produtoController = new ProdutoController();

        int opcao;

        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Cadastrar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    Cliente cliente = new Cliente();
                    System.out.print("Nome do cliente: ");
                    cliente.setNome(scanner.nextLine());
                    System.out.print("CPF do cliente: ");
                    cliente.setCpf(scanner.nextLine());
                    System.out.print("Telefone do cliente: ");
                    cliente.setTelefone(scanner.nextLine());
                    System.out.print("Email do cliente: ");
                    cliente.setEmail(scanner.nextLine());
                    clienteController.salvarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    Funcionario funcionario = new Funcionario();
                    System.out.print("Nome do funcionário: ");
                    funcionario.setNome(scanner.nextLine());
                    System.out.print("Cpf do funcionário: ");
                    funcionario.setCpf(scanner.nextLine());
                    System.out.print("Cargo: ");
                    funcionario.setCargo(scanner.nextLine());
                    System.out.print("Salário: ");
                    funcionario.setSalario(scanner.nextDouble());
                    scanner.nextLine(); // limpar buffer
                    funcionarioController.salvarFuncionario(funcionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 3:
                    Produto produto = new Produto();
                    System.out.print("Nome do produto: ");
                    produto.setNome(scanner.nextLine());
                    System.out.print("Preço do produto: ");
                    produto.setPreco(scanner.nextDouble());
                    scanner.nextLine(); // limpar buffer
                    System.out.print("Descrição: ");
                    produto.setDescricao(scanner.nextLine());
                    produtoController.salvarProduto(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
