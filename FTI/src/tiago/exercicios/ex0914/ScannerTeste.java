package tiago.exercicios.ex0914;

import java.util.Scanner;

public class ScannerTeste {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Insira o primeiro n�mero:");
		int n1 = teclado.nextInt();
		
		System.out.println("Insira o segundo n�mero:");
		int n2 = teclado.nextInt();
		
		System.out.println("O resultado �:\n" + n1 + " + " + n2 + " = " + (n1+n2));
		teclado.close();
	}

}