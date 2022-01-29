package vetores;

import java.util.Random;
import java.util.Scanner;

public class exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		Random aleatorio = new Random();
		
		double media = 0.0, soma =0.0;
		
		int maior = 0;
		
		int[] arrayVetor = new int[10];
		
				for(int i=0; i <=9; i++) {
					arrayVetor[i] = aleatorio.nextInt(30);
					System.out.println(i +"-"+ arrayVetor[i]);
					soma += arrayVetor[i];
					media = soma /(i=1);
					if(arrayVetor[i]> maior) {
						maior= arrayVetor[i];
					}
				}
					System.out.println("A média aritmética é:"+ media1);
					System.out.println("A maior ocorrência de valor foi:"+ maior);
	}

}
