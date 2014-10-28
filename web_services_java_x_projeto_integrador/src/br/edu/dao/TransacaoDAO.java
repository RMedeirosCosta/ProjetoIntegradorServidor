package br.edu.dao;

import br.edu.modelo.Transacao;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    
    private List<Transacao> transacoes;
    
    public TransacaoDAO() {
        transacoes = new ArrayList<>();
    }            
    
    public List<Transacao> get() {
        return transacoes;
    }
    
    public List<Transacao> get(Long numeroConta) {
        List<Transacao> retornos = new ArrayList<>();
        
        for (Transacao transacao : transacoes) {
            if (transacao.getConta().equals(numeroConta))
                retornos.add(transacao);
        }
        
        if (retornos.isEmpty())
            return null;
        else                   
            return retornos;
    }
    
    public void salvar(Transacao transacao) {
        this.transacoes.add(transacao);
    }
}
