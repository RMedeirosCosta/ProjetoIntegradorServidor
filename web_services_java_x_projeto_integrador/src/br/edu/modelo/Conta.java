package br.edu.modelo;

public class Conta {
    private Long numero;
    // poderia ter usado um tipo cliente, mas fiz com string pra simplificar
    private String cliente; 
    private Double saldo;
    
    public Conta(Long numero, String cliente, Double saldo) {
        if (numero <= 0)
            throw new IllegalArgumentException("Numero da conta precisa "
                                                .concat("ser maior que zero!"));
        
        if (saldo < 0)
            throw new IllegalArgumentException("Saldo nao pode ser negativo!");
        
        if ((cliente == null) || (cliente.isEmpty()))
            throw new IllegalArgumentException("Cliente inválido!");
        
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
    }
    
    public Conta(Long numero) {
        this.numero = numero;
    }

    public Long getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }
    
    @Override
    public boolean equals(Object objeto) {
        // Se não for do tipo Conta, então obviamente não é igual
        if (!(objeto instanceof Conta))
          return false;
        
        Conta c = (Conta)objeto;
        
        // Se o número da conta for igual, então é a mesma conta.
        return (c.getNumero().equals(this.numero));
    }

    public void depositar(double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("Valor de deposito invalido!");
        
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("Valor de saque invalido!");
        
        if (valor > saldo)
          throw new IllegalArgumentException("Nao ha a quantia para o saque!");
        
        saldo -= valor;
    }

}
