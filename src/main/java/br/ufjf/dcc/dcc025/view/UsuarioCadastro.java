/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import br.ufjf.dcc.dcc025.model.Categoria;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class UsuarioCadastro extends JFrame { 
    
    private JPanel pnlPrincipal;
    private JTextField edtNome;
    private JTextField edtEmail;
    private JPasswordField edtSenha;
    private JComboBox cbbCategoria;
    private int equipeId;
    
    
    
    public UsuarioCadastro(){
        super("Cadastro de Usuário");      
        this.addWindowListener(new AtualizaDadosBase(this));
        initComponents();
    }
    
    private void initComponents() {
        this.pnlPrincipal = new JPanel();
        this.pnlPrincipal.setLayout(new BorderLayout());

        desenhaTela();
        desenhaRodape();
        this.add(this.pnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.repaint();

        this.setVisible(true);
    }
    
    private void desenhaTela() {
        JPanel painelTela;
        painelTela = new JPanel(new GridLayout(0, 2));
        
        JPanel painelNomeField = new JPanel(new GridLayout(0, 2));
        JPanel painelEmailField = new JPanel(new GridLayout(0, 2));
        JPanel painelSenhaField = new JPanel(new GridLayout(0, 2));
        JPanel painelCategoriaField = new JPanel(new GridLayout(1, 1));
        JPanel painelEquipeButton = new JPanel(new GridLayout(0, 1));
                
        JLabel lblNome = new JLabel("Nome:");
        edtNome = new JTextField(20);
        painelNomeField.add(lblNome, BorderLayout.WEST);
        painelNomeField.add(edtNome, BorderLayout.EAST);
        
        JLabel lblEmail = new JLabel("Email:");
        edtEmail = new JTextField(20);
        painelEmailField.add(lblEmail, BorderLayout.WEST);
        painelEmailField.add(edtEmail, BorderLayout.EAST);
        
        JLabel lblSenha = new JLabel("Senha:");
        edtSenha = new JPasswordField(20);
        painelSenhaField.add(lblSenha, BorderLayout.WEST);
        painelSenhaField.add(edtSenha, BorderLayout.EAST);
        
        JLabel lblCategoria = new JLabel("Categoria:");
        cbbCategoria = new JComboBox(Categoria.values());
        painelCategoriaField.add(lblCategoria, BorderLayout.WEST);
        painelCategoriaField.add(cbbCategoria, BorderLayout.EAST);
        
        JButton btnEscolherEquipe = new JButton("Escolher Equipe");
        btnEscolherEquipe.addActionListener((ActionEvent arg0) -> {
            EscolherEquipe();
        });
        painelEquipeButton.add(btnEscolherEquipe, BorderLayout.EAST);
      
        painelTela.add(painelNomeField, BorderLayout.CENTER);
        painelTela.add(painelEmailField, BorderLayout.CENTER);        
        painelTela.add(painelSenhaField, BorderLayout.CENTER);
        painelTela.add(painelCategoriaField, BorderLayout.CENTER);
        painelTela.add(painelEquipeButton, BorderLayout.CENTER);        
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }

    private void desenhaRodape() {
        JPanel painelBotoes = new JPanel();
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener((ActionEvent arg0) -> {
            Salvar();
        });
        painelBotoes.add(btnSalvar, BorderLayout.EAST);
        
             
        pnlPrincipal.add(painelBotoes, BorderLayout.SOUTH);    
    }

    private void Salvar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void EscolherEquipe() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
