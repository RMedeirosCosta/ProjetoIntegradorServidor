package br.edu.contrato;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface BancarioService {
     public @WebResult(name="numeroConta") long
     criarConta(@WebParam(name="nomeCliente") String nomeCliente,
                @WebParam(name="saldoInicial") double saldo)
            throws Exception;
     
     public @WebResult(name="saldoConta") double
     consultarSaldo(@WebParam(name="numeroConta") long numConta)
            throws Exception;
     
     public @WebResult(name="resposta") String
     efetuarDeposito(@WebParam(name="numeroConta") long numConta,
                     @WebParam(name="valorDepositado") double valor)
            throws Exception;
     
     public @WebResult(name="resposta") String
     efetuarSaque(@WebParam(name="numeroConta") long numConta,
                  @WebParam(name="valorSacado") double valor)
            throws Exception;
     
     public @WebResult(name="resposta") String
     fecharConta(@WebParam(name="numeroConta") long numConta)
            throws Exception; 
}
