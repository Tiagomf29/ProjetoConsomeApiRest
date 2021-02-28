package br.com.carregaposts.cliente;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.carregaposts.domain.Posts;
import br.com.carregaposts.menu.MenuSistema;
import br.com.carregaposts.service.ServicoPosts;

public class Main {

	public static void main(String[] args) throws Exception {
		 
		    Boolean pareExecutar = false;
		    int valor = 0;
		    ArrayList<Posts> posts;
		    while(!pareExecutar) {	
		    	valor = MenuSistema.executaMenu();
		        if(valor == 1)
		          posts = ServicoPosts.buscaEnderecoPelo(1); 
		        else  
		          posts = ServicoPosts.buscaEnderecoPelo(2);
		        
		        for(int i = 0; i < posts.size();i++) {
		        	System.out.println("ID: "+ posts.get(i).getId());
		        	System.out.println("Título: "+posts.get(i).getTitle());
		        	
		        	if(valor==1) 
		        	  System.out.println("Postagem: "+posts.get(i).getBody());
		        	
		        	System.out.println("=====================");	
		        }
		        
		        System.out.println("Deseja voltar para o menu inicial? sem Sim digite 1 senão digite qualquer valor");
		        Scanner sc = new Scanner(System.in);
		        int a = sc.nextInt();
		        
		        if (a != 1) {
		        	pareExecutar = true;
		        }
		        
		   }

		       
		    }
}
