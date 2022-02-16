package br.com.generation.Listas.HerancaPolimorfismo.Exercicio3;

public class Item {
	private String nome;
	private int quantidade;
	private double preco;
	private static int totalItems = 0;

	public Item(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		Item.totalItems += 1;
	}
	
	@Override
	public String toString() {
		String texto = "Nome: " + this.nome + " | "
				+ "Quantidade: " + this.quantidade + " | Preço" + this.preco + "\n";
		return texto;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void mostrarTotal() {
		System.out.println("Total de itens no estoque: " + Item.totalItems);
	}
}
