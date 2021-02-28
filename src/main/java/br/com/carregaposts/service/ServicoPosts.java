package br.com.carregaposts.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;

import br.com.carregaposts.Utils;
import br.com.carregaposts.domain.Posts;

public class ServicoPosts {
	 static String webService = "https://jsonplaceholder.typicode.com/";
	    static int codigoSucesso = 200;

	    public static ArrayList<Posts> buscaEnderecoPelo(int valor) throws Exception {
	    	String urlParaChamada;
	    	
	    	if(valor == 1)
	           urlParaChamada = webService  + "posts";
	    	else if(valor == 2)
	    	   urlParaChamada = webService  + "albums";
	    	else
	    		urlParaChamada = webService  + "todos";	

	        try {
	            URL url = new URL(urlParaChamada);
	            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

	            if (conexao.getResponseCode() != codigoSucesso)
	                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

	            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            Gson gson = new Gson();
	            String jsonEmString = Utils.converteJsonEmString(resposta);
	            Type tipoLista = new TypeToken<ArrayList<Posts>>() {}.getType();
	            ArrayList<Posts> lista = gson.fromJson(jsonEmString, tipoLista);	            	        
	           
	           // Posts endereco = gson.fromJson(jsonEmString, Posts.class);

	            return lista;
	        } catch (Exception e) {
	            throw new Exception("ERRO: " + e);
	        }
	    }
}
