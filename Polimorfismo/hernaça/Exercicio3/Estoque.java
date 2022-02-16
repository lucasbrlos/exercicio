package br.com.generation.Listas.HerancaPolimorfismo.Exercicio3;

import java.util.ArrayList;
import java.util.List;

public abstract class Estoque {
	private static List<Item> estoque = new ArrayList<Item>();
	
	public static void listar() {
		if (estoque.size() > 0) {
			for (Item item: estoque) {
				item.toString();
			}
			estoque.get(0).mostrarTotal();
		} else {
			System.out.println("Nenhuma mercadoria no estoque.");
		}
	}

	public static void adicionar(String itemNome, int quantidade, double preco) {
		int indiceItemExistente = procurarItem(itemNome);
		if (indiceItemExistente != -1) {
			atualizar(indiceItemExistente, quantidade);
			System.out.println("Item já existente, adicionando quantidade inserida.");
		} else {
			Item item = new Item(itemNome, quantidade, preco);
			estoque.add(item);
			System.out.println(item.getNome() + " foi adicionado!");
		}
	}
	
	public static int procurarItem(String nome) {
		for (int i = 0; i < estoque.size(); i++) {
			if (estoque.get(i).getNome() == nome) {
				return i;
			}
		}
		return -1;
	}
	
	public static void remover(String nome) {
		int i = 0;
		for (Item item: estoque) {
			if (item.getNome() == nome){
				estoque.remove(i);
			}
			i++;
		}
	}
	
	public static void atualizar(int indice, String nome) {
		Item item = estoque.get(indice);
		item.setNome(nome);
	}

	public static void atualizar(int indice, int quantidade) {
		Item item = estoque.get(indice);
		item.setQuantidade(quantidade);
	}

	public static void atualizar(int indice, double preco) {
		Item item = estoque.get(indice);
		item.setPreco(preco);
	}
}
