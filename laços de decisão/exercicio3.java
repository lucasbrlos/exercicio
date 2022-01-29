package aula02lacçoderepetição;

import java.util.Scanner;

public class exercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leia = new Scanner(System.in);
		int idade = 0;
		
		System.out.println("Digite a sua idade");
		idade = leia.nextInt();
		if (idade >= 10 && idade <=14 ) {
			System.out.println("10-14 infantil");
			}
			if(idade >= 15 && idade <= 17) {
			System.out.println("15-17 juvenis");	
			}
			if(idade >=18 && idade <= 25) {
				System.out.println("18-25 adultos");
			}	else {
				System.out.println("Você não estara na categoria");
			}
	}

}
