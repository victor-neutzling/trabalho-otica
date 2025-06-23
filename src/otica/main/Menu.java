package otica.main;

import java.util.List;
import java.util.Scanner;

import otica.controllers.ClienteController;
import otica.controllers.FuncionarioController;
import otica.controllers.PedidoController;
import otica.controllers.ProdutoController;
import otica.model.Cliente;
import otica.model.Funcionario;
import otica.model.Pedido;
import otica.model.Produto;


public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ClienteController clienteController = new ClienteController();
        FuncionarioController funcionarioController = new FuncionarioController();
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();
        
        int opcao;

        do {
            System.out.println("\n===== escolha uma opção =====");
            System.out.println("1. login cliente");
            System.out.println("2. login funcionario");
            System.out.println("3. cadastro cliente");
            System.out.println("4. cadastro funcionario");
            
            System.out.println("0. sair");
            
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
            	case 1: 
            		//pagina do cliente
            		System.out.println("insira o cpf do cliente: ");
            		String cpfCliente = scanner.nextLine();
           
            		int opcaoCliente;
            		
            		if(clienteController.login(cpfCliente)) {
            			System.out.println("logado com sucesso!");
            			do {
                			System.out.println("\n===== escolha uma opção =====");
                            System.out.println("1. listar produtos");
                            System.out.println("2. comprar produto");
                            System.out.println("0. sair");
                            
                            System.out.print("Escolha uma opção: ");
                            opcaoCliente = scanner.nextInt();
                            scanner.nextLine(); 
                			
                            switch(opcaoCliente) {
                            	case 1:
                            		//listar produtos
                            		List<Produto> produtos = produtoController.listarProdutos();
                            		
                            		for(Produto produto : produtos) {
                            			System.out.println("id: "+produto.getProdutoID());
                            			System.out.println("nome: "+produto.getNome());
                            			System.out.println("descrição: "+produto.getDescricao());
                            			System.out.println("preço: "+produto.getPreco());
                            			System.out.println("=========================");
                            		}
                            		break;
                            	case 2:
                            		//comprar produto
                            		System.out.println("Insira o ID do produto: ");
                            		int produtoID = scanner.nextInt();
                            		scanner.nextLine();
                            		System.out.println("Insira o metodo de pagamento: ");
                            		String metodoPagamento = scanner.nextLine();
                            		
                            		Pedido pedido = new Pedido();
                            		pedido.setClienteID(clienteController.getClienteByCPF(cpfCliente).getClienteID());
                            		pedido.setMetodo_pagamento(metodoPagamento);
                            		pedido.setProdutoID(produtoID);
                            		pedido.setValorTotal(produtoController.getProdutoByID(produtoID).getPreco());
                                                 		
                            		pedidoController.cadastrarPedido(pedido);
                            		System.out.println("produto comprado com sucesso!");
                            		break;
                            }
                            
                		} while (opcaoCliente != 0);
            		}else {
            			System.out.println("cpf incorreto!");
            		}
            		
            		break;
            	case 2:
            		System.out.println("insira o cpf do funcionario: ");
            		String cpfFuncionario = scanner.nextLine();
            		
            		int opcaoFuncionario;
                    
                    if(funcionarioController.login(cpfFuncionario)) {
                    	System.out.println("logado com sucesso!");
                    	do {
                        	System.out.println("\n===== escolha uma opção =====");
                            System.out.println("1. cadastrar produto");
                            System.out.println("2  deletar produto");
                            System.out.println("0. sair");
                            
                            System.out.print("Escolha uma opção: ");
                            opcaoFuncionario = scanner.nextInt();
                            scanner.nextLine(); 
                            
                            switch(opcaoFuncionario) {
                            	case 1:
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
                            	case 2:
                        			List<Produto> produtos = produtoController.listarProdutos();
                            		
                        			for(Produto produtoListado : produtos) {
	                        			System.out.println("id: "+produtoListado.getProdutoID());
	                        			System.out.println("nome: "+produtoListado.getNome());
	                        			System.out.println("descrição: "+produtoListado.getDescricao());
	                        			System.out.println("preço: "+produtoListado.getPreco());
	                        			System.out.println("=========================");
                        			}
                            		
                            		System.out.println("insira o id do produto: ");
                            		produtoController.excluirProduto(scanner.nextInt());
                            		System.out.println("Produto excluido com sucesso!");
                                    scanner.nextLine(); // limpar buffer
                            		break;
                            }
                        } while (opcaoFuncionario != 0);
                    }else {
                    	System.out.println("cpf incorreto!");
                    }

            		break;
            	case 3:
            		//cadastro de cliente
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
            	case 4:
            		//cadastro de funcionario
            		Funcionario funcionario = new Funcionario();
            		
                    System.out.print("Nome do funcionário: ");
                    funcionario.setNome(scanner.nextLine());
                    System.out.print("Cpf do funcionário: ");
                    funcionario.setCpf(scanner.nextLine());
                    System.out.print("Cargo do funcionário: ");
                    funcionario.setCargo(scanner.nextLine());
                    System.out.print("Salário do funcionário: ");
                    funcionario.setSalario(scanner.nextDouble());
                    scanner.nextLine();
                    
                    funcionarioController.salvarFuncionario(funcionario);
                    
                    System.out.println("Funcionário cadastrado com sucesso!");
            		break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}