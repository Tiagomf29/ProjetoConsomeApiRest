package br.com.carregaposts.menu;

import java.util.Scanner;

public class MenuSistema {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int executaMenu() {
		
		System.out.println("=================================================\n");
		
		System.out.println("Sistema de consumo de API\n");

		System.out.println("=================================================\n");
		
		System.out.println("[1] Para listar todas as postagens digite o numero 1");
		System.out.println("[2] Para listar todos os albuns digite o numero 2");
		System.out.println("[3] Para listar todos digite o numero 3");
		
		int valor = sc.nextInt();
		
		return valor;
		
	}
	

}
