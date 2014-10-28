package br.edu.aplicacao;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class ServidorTransacao {
    public static void main(String[] args) {
        try {
            // Alterado a porta para não dar conflito com o servidor WSDL
            HttpServer server = HttpServerFactory.create("http://localhost:4000/");
            server.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}
