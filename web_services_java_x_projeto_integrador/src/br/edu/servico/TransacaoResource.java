package br.edu.servico;

import br.edu.dao.TransacaoDAO;
import br.edu.modelo.Transacao;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

@Path("transacao")
public class TransacaoResource {
    
    // Ao criar inicia a lista de transacoes pela primeira vez
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transacao> getTransacoes() {
        try {
            TransacaoDAO dao = new TransacaoDAO();
            return dao.get();
        } catch (ParseException | ParserConfigurationException |
                 SAXException | IOException ex) {
            return null;
        }
    }    
    
    @Path("{numero_conta}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transacao> get(@PathParam("numero_conta") long numeroConta) {        
        try {
            TransacaoDAO dao = new TransacaoDAO();
            return dao.get(numeroConta);
        } catch (ParseException | ParserConfigurationException |
                 SAXException | IOException ex) {
            return null;
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Transacao adicionarTransacao(Transacao transacao) {        
        try {
            TransacaoDAO dao = new TransacaoDAO();
            dao.salvar(transacao);            
            return transacao;
        } catch (ParserConfigurationException | SAXException |
                 IOException | TransformerException ex) {
            return null;
        }
    }
    
    /**
     * Não foi encontrado de acordo com os requisitos do cliente a necessidade
     * de criar para o método PUT e para o método DELETE do HTTP.
     * */
    
}
