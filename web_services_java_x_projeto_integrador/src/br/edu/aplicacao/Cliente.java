package br.edu.aplicacao;

import br.edu.contrato.OperadorBancario;
import br.edu.gui.JanelaCliente;

public class Cliente {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            OperadorBancario operador = null; // Chamar classe concreta aqui
            
            public void run() {
                new JanelaCliente(operador).setVisible(true);
            }
        });        
    }
}
