package br.com.generation.Listas.HerancaPolimorfismo.Exercicio3;

import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);

	public void apresentacao() {
		int escolha;
		
		do {
			System.out.println("O que deseja fazer?");
			System.out.println("1-Cadastrar novo item no estoque.\n2-Atualizar item\n"
					+ "3-Remover item\n4-Listar mercadorias\n5-Sair");
			escolha = sc.nextInt();
			
			switch (escolha) {
			case 1:
				cadastrarNovoItem();
				break;
			case 2:
				atualizarItem();
				break;
			case 3:
				removerItem();
				break;
			case 4:
				Estoque.listar();
				break;
			case 5:
				break;
			default:
				System.out.println("Digite uma das opções corretamente!");
			}
		} while(escolha != 4);

		sc.close();
	}

	private void cadastrarNovoItem() {
		String nome;
		int quantidade;
		double preco;

		System.out.println("=======================================");
		System.out.println("\tCADASTRO DE NOVA MERCADORIA");
		System.out.println("=======================================");
		System.out.printf("Nome: ");
		nome = sc.nextLine();
		sc.nextLine();
		System.out.printf("Quantidade: ");
		quantidade = sc.nextInt();
		System.out.printf("Preço :");
		preco = sc.nextDouble();

		Estoque.adicionar(nome, quantidade, preco);
	}

	private void atualizarItem() {
		// TODO Auto-generated method stub
		System.out.printf("Digite o nome do item que deseja procurar: ");
		String nome = sc.nextLine();
		int indiceItemExistente = Estoque.procurarItem(nome);
		if (indiceItemExistente != -1) {
			System.out.println("O que deseja alterar no item " + nome + "?");
			System.out.println("1-Nome");
			System.out.println("2-Quantidade");
			System.out.println("3-Preço");
			System.out.println("4-Sair");
			int escolha = sc.nextInt();
			
			switch (escolha) {
			case 1:
				System.out.printf("Qual o novo nome? ");
				String novoNome = sc.nextLine();
				Estoque.atualizar(indiceItemExistente, novoNome);
				break;
			case 2:
				System.out.printf("Qual a nova quantidade? ");
				int novaQuantidade = sc.nextInt();
				Estoque.atualizar(indiceItemExistente, novaQuantidade);
				break;
			case 3:
				System.out.println("Qual o novo preço? ");
				double novoPreco = sc.nextDouble();
				Estoque.atualizar(indiceItemExistente, novoPreco);
				break;
			default:
				System.out.println("Voltando para o menu...");
			}
		} else {
			System.out.println("Item não existe no estoque.");
		}
	}

	private void removerItem() {
		// TODO Auto-generated method stub
		
	}
}
