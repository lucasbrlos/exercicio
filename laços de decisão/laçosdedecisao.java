package aula02lacçoderepetição;

import java.util.Scanner;

public class laçosdedecisao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);
		
		int a,b,c;
		System.out.println("digite o primeiro valor");
		a= leia.nextInt();
		
		System.out.println("digite o segundo valor");
		b= leia.nextInt();
		
		System.out.println("digite o teceiro valor");
		c= leia.nextInt();
		
		if (a> b && a> c  )
			System.out.println("valor"+a);
		
	}

}
