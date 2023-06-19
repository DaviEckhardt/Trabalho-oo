/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosListagem;
import br.ufjf.dcc.dcc025.utils.ImageUtils;

/**
 *
 * @author Gabriel
 */
public class Login extends javax.swing.JFrame {

    private JPanel pnlPrincipal;
    private JTextField edtLogin;
    private JPasswordField edtSenha;
    
    public Login() {        
        super("Login");        
        //this.addWindowListener(new AtualizaDadosListagem(this));
        initComponents();
    }

    private void initComponents() {
        this.setSize(WIDTH, HEIGHT);

        this.pnlPrincipal = new JPanel();
        this.pnlPrincipal.setLayout(new BorderLayout());


        desenhaTela();
        this.add(this.pnlPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.repaint();

        this.setVisible(true);
    }

    private void desenhaTela() {
        JPanel painelLogin;
        painelLogin = new JPanel();
        painelLogin.setBorder(BorderFactory.createTitledBorder("Login"));
        //painelLogin.setPreferredSize(new Dimension(VWIDTH, 50));
        
        JPanel painelLoginField = new JPanel(new GridLayout(0, 1));
        JPanel painelSenhaField = new JPanel(new GridLayout(0, 1));
        JPanel painelButton = new JPanel(new GridLayout(0, 1));
        
        JButton btnLogin = new JButton("Entrar");      
        
        edtLogin = new JTextField(20);
        edtSenha = new JPasswordField(20);
        painelLoginField.add(edtLogin, BorderLayout.CENTER);
        painelSenhaField.add(edtSenha, BorderLayout.CENTER);
        
        painelButton.add(btnLogin, BorderLayout.CENTER);  

        painelLogin.add(painelLoginField, BorderLayout.CENTER);
        painelLogin.add(painelSenhaField, BorderLayout.CENTER);
        painelLogin.add(btnLogin, BorderLayout.CENTER);
        
        this.pnlPrincipal.add(painelLogin, BorderLayout.NORTH);
    }
}
