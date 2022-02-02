package aulametodos;

public class TestaAvião {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Avião a1 = new Avião();
			
			a1.nome = "Ed Force One";
			a1.Marca = "Boeing 747-400";
			a1.ano = 2003;
			a1.velocidade=988;
			
			a1.acelerar(0);
			System.out.println("O Avião decolou e agora está a uma Velocidade de:+a1.velocidade+ km/h");
			
			a1.freiar(988);
			System.out.println("\nO Avião pousou com segurança,e agora o velocimetro marca" + a1.freiar + "Km/h");
	}

}
