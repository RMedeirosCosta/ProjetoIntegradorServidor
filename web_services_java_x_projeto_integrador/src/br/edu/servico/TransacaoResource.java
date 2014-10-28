package br.edu.servico;

import br.edu.dao.TransacaoDAO;
import br.edu.modelo.Transacao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("transacao")
public class TransacaoResource {
    
    // Ao criar inicia a lista de transacoes pela primeira vez
    private static TransacaoDAO dao = new TransacaoDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transacao> getTransacoes() {
        return dao.get();
    }    
    
    @Path("{numero_conta}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transacao> get(@PathParam("numero_conta") long numeroConta) {        
        return dao.get(numeroConta);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Transacao adicionarTransacao(Transacao transacao) {        
        dao.salvar(transacao);
        return transacao;
    }
    
    /**
     * Não foi encontrado de acordo com os requisitos do cliente a necessidade
     * de criar para o método PUT e para o método DELETE do HTTP.
     * */
    
}
