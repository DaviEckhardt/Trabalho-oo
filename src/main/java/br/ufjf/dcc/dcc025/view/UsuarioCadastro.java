/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import br.ufjf.dcc.dcc025.exception.EmailException;
import br.ufjf.dcc.dcc025.model.Categoria;
import br.ufjf.dcc.dcc025.model.Email;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.model.IPesquisa;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class UsuarioCadastro extends CadastroBase implements IPesquisa<Equipe> { 
    private int id = 0;
    private JTextField edtNome;
    private JTextField edtEmail;
    private JPasswordField edtSenha;
    private JComboBox cbbCategoria;
    private int equipeId;   
    
    private final UsuarioRepository repository;
        
    public UsuarioCadastro(){
        this(null);
    }        
    public UsuarioCadastro(ListagemUsuario telaListagem){
        super("Cadastro de Usuário", telaListagem);
        repository = new UsuarioRepository();        
    } 
    
    public static void Cadastrar(){
        Cadastrar(null);
    }
    public static void Cadastrar(ListagemUsuario listagem){
        UsuarioCadastro cadastro = new UsuarioCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
    }
    public static boolean Editar(Usuario usuario){
        return Editar(null, usuario);
    }
    public static boolean Editar(ListagemUsuario listagem, Usuario usuario){
        UsuarioCadastro cadastro = new UsuarioCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
        cadastro.carregar(usuario);
        return true;
    }    
    
    @Override
    protected void desenhaTela() {
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
            ListagemEquipe.Selecionar(this);
        });
        painelEquipeButton.add(btnEscolherEquipe, BorderLayout.EAST);
      
        painelTela.add(painelNomeField, BorderLayout.CENTER);
        painelTela.add(painelEmailField, BorderLayout.CENTER);        
        painelTela.add(painelSenhaField, BorderLayout.CENTER);
        painelTela.add(painelCategoriaField, BorderLayout.CENTER);
        painelTela.add(painelEquipeButton, BorderLayout.CENTER);        
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }


    @Override
    protected void Salvar() {
        try {
            if(!Validar())
                return;
            
            Usuario usuario;            
            String nome = edtNome.getText();
            Email email = new Email(edtEmail.getText());
            String senha = new String(edtSenha.getPassword());
            Categoria categoria = (Categoria) cbbCategoria.getSelectedItem();           
            
            if(categoria == Categoria.Gerencia)
                usuario = Usuario.UsuarioCapitao(id, nome, email, senha, equipeId);
            else
                usuario = Usuario.UsuarioCompetidor(id, nome, email, senha, equipeId, categoria);
            
            repository.save(usuario);            
        } catch (EmailException ex) {
            // já protegido dentro do validar
        }
        
        this.setVisible(false);
        this.dispose();
    }

    @Override
    protected boolean Validar() {
        if(edtNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome inválido!");
            return false;
        }
        
        try {            
            Email email = new Email(edtEmail.getText());
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return false;
        }
        
        if(new String(edtSenha.getPassword()).isBlank()){
            JOptionPane.showMessageDialog(this, "Senha inválida!");
            return false;
        }
        
        if(cbbCategoria.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(this, "Categoria inválida!");
            return false;
        }

        if(equipeId <= 0){
            JOptionPane.showMessageDialog(this, "Equipe inválida!");
            return false;
        }
            
        return true;
    }
    private void carregar(Usuario usuario) {
        id = usuario.getId();
        edtNome.setText(usuario.getNome());
        edtEmail.setText(usuario.getEmail());
        edtSenha.setText(usuario.getSenha());
        cbbCategoria.setSelectedItem(usuario.getCategoria());
        equipeId = usuario.getEquipeId();
    }

    @Override
    public void ReceberPesquisa(Equipe equipe) {
        if(equipe != null)
            equipeId = equipe.getId();
        else
            equipeId = 0;
    }
}
