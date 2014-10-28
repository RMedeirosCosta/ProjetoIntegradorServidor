package br.edu.gui;

import br.edu.contrato.OperadorBancario;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class JanelaCliente extends JFrame {

    // Constantes para melhorar a visualização 
    private static final Integer COMPRIMENTO = 400;
    private static final Integer LARGURA     = 205;    
    
    // Componentes visuais organizados hierarquicamente
    private JButton btnCriarConta;    
    private JButton btnConsultarSaldo;    
    private JButton btnEfetuarDeposito;
    private JButton btnEfetuarSaque;
    private JButton btnFecharConta;
    private JButton btnListarTodasTransacoesConta;
    private JButton btnListarTodasTransacoes;
    
    private OperadorBancario operador;
    
    public JanelaCliente(OperadorBancario servico) {
        super();
        
        super.setTitle(" Projeto Integrador - "
                                  .concat("Ricardo Medeiros da Costa Junior"));
        
        setSize(new Dimension(COMPRIMENTO, LARGURA));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        inicializarComponentes();
        inicializarOuvintes();        
    }
    
    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this,
                                      erro,
                                      "Erro",
                                      JOptionPane.ERROR_MESSAGE);
    }    
    
    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this,
                                      mensagem,
                                      "Informação",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    private void inicializarComponentes() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        
        btnCriarConta = new JButton("1 - Criar Conta");
        btnCriarConta.setMnemonic('1');
        btnCriarConta.setToolTipText("Clique aqui para criar uma nova conta ");       
        btnCriarConta.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnConsultarSaldo = new JButton("2 - Consultar Saldo");
        btnConsultarSaldo.setMnemonic('2');
        btnConsultarSaldo.setToolTipText("Clique aqui para consultar seu saldo");       
        btnConsultarSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnEfetuarDeposito = new JButton("3 - Efetuar Depósito");
        btnEfetuarDeposito.setMnemonic('3');
        btnEfetuarDeposito.setToolTipText("Clique aqui para efetuar um depósito");
        btnEfetuarDeposito.setAlignmentX(Component.CENTER_ALIGNMENT);        
        
        btnEfetuarSaque = new JButton("4 - Efetuar Saque");
        btnEfetuarSaque.setMnemonic('4');
        btnEfetuarSaque.setToolTipText("Clique aqui para efetuar um saque");
        btnEfetuarSaque.setAlignmentX(Component.CENTER_ALIGNMENT);        

        btnFecharConta = new JButton("5 - Fechar Conta");
        btnFecharConta.setMnemonic('5');
        btnFecharConta.setToolTipText("Clique aqui fechar uma conta");
        btnFecharConta.setAlignmentX(Component.CENTER_ALIGNMENT);        

        btnListarTodasTransacoesConta = new JButton("6 - Listar Transações "
                                               .concat("de Determinada Conta"));
        btnListarTodasTransacoesConta.setMnemonic('6');
        btnListarTodasTransacoesConta.setToolTipText("Clique aqui para "
                    .concat("listar todas as transações de determinada conta"));
        btnListarTodasTransacoesConta.setAlignmentX(Component.CENTER_ALIGNMENT);        

        btnListarTodasTransacoes = new JButton("7 - Listar Todas Transações");
        btnListarTodasTransacoes.setMnemonic('7');
        btnListarTodasTransacoes.setToolTipText("Clique aqui para listar "
                                                .concat("todas as transações"));
        btnListarTodasTransacoes.setAlignmentX(Component.CENTER_ALIGNMENT);        

        getContentPane().add(btnCriarConta);
        getContentPane().add(btnConsultarSaldo);
        getContentPane().add(btnEfetuarDeposito);
        getContentPane().add(btnEfetuarSaque);
        getContentPane().add(btnFecharConta);
        getContentPane().add(btnListarTodasTransacoesConta);
        getContentPane().add(btnListarTodasTransacoes);
    }

    private void inicializarOuvintes() {
    }    
}
