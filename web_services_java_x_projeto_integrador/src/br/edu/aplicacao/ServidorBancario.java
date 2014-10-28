package br.edu.aplicacao;

import br.edu.servico.BancarioService;
import javax.xml.ws.Endpoint;

public class ServidorBancario {
    
    public static void main(String[] args) {
        System.out.println("Iniciando servico bancario...");
        BancarioService servico = new BancarioService();
        Endpoint.publish("http://localhost:3000/BancarioService", servico);            
    }
}
