package br.edu.servico;

import br.edu.modelo.Conta;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(endpointInterface="br.edu.contrato.BancarioService")
public class BancarioService implements br.edu.contrato.BancarioService {
    
    @Resource
    private WebServiceContext wsContext;    
    ArrayList<Conta> contas = new ArrayList<>();    

    @Override
    public long criarConta(String nomeCliente, double saldo) throws Exception {
        // O número da conta será a quantidade da conta na lista de contas
        long numero = (long)(contas.size() + 1);
        Conta conta = new Conta(numero, nomeCliente, saldo);
        contas.add(conta);
        return conta.getNumero();
    }

    @Override
    public double consultarSaldo(long numConta) throws Exception {
        Conta c = new Conta(numConta);
        
        try {
            c = contas.get(contas.indexOf(c));        
        
            return c.getSaldo();
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    @Override
    public String efetuarDeposito(long numConta, double valor) throws Exception {
        Conta c = new Conta(numConta);
        
        try {
            c = contas.get(contas.indexOf(c));        
        
            c.depositar(valor);
            return "Deposito realizado com sucesso!";
        } catch (IndexOutOfBoundsException e) {
            return "Conta ".concat(String.valueOf(numConta)).concat(" inexistente");
        }        
    }

    @Override
    public String efetuarSaque(long numConta, double valor) throws Exception {
        Conta c = new Conta(numConta);
        
        try {
            c = contas.get(contas.indexOf(c));        
        
            c.sacar(valor);
            return "Saque realizado com sucesso!";
        } catch (IndexOutOfBoundsException e) {
            return "Conta ".concat(String.valueOf(numConta)).concat(" inexistente");
        }       
        
    }

    @Override
    public String fecharConta(long numConta) throws Exception {
        Conta c = new Conta(numConta);
        
        try {
            c = contas.get(contas.indexOf(c));
        
        
            contas.remove(c);
            return "Conta finalizada com sucesso!";
        } catch (IndexOutOfBoundsException e) {
            return "Conta ".concat(String.valueOf(numConta)).concat(" inexistente");
        }                   
    }
    
}
