package aulametodos;

public class TestaAvi�o {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Avi�o a1 = new Avi�o();
			
			a1.nome = "Ed Force One";
			a1.Marca = "Boeing 747-400";
			a1.ano = 2003;
			a1.velocidade=988;
			
			a1.acelerar(0);
			System.out.println("O Avi�o decolou e agora est� a uma Velocidade de:+a1.velocidade+ km/h");
			
			a1.freiar(988);
			System.out.println("\nO Avi�o pousou com seguran�a,e agora o velocimetro marca" + a1.freiar + "Km/h");
	}

}
