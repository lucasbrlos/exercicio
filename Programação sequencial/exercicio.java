package br.aula01;

import java.util.Scanner;

public class exercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a,b,resultado;
		int op;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("escolha a operação 1-adicao 2-sub 3-mul 4-divisão 5-resto");
		op=sc.nextInt();
		
		System.out.println("valor 1:");
		a=sc.nextDouble();
		
		System.out.println("valor 2:");
		b=sc.nextDouble();
		
		switch(op) {
		case 1:
			resultado=a+b;
			System.out.println("resultado de "+a+"+"+b+"="+resultado);
			break;
		case 2:
			resultado=a-b;
			System.out.println("resultado de"+a+"-"+b+"="+resultado);
			break;
		case 3:
			resultado=a*b;
			System.out.println("resultado de"+a+"*"+b+"="+resultado);
			break;
		case 4:
			resultado=a/b;
			System.out.println("resultado de"+a+"/"+b+"="+resultado);
			break;
		case 5:
			resultado=a%b;
			System.out.println("resto da"+a+"/"+b+"="+resultado);
			break;
		
		} 
	}

}