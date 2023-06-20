package br.ufjf.dcc.dcc025.view;
import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import br.ufjf.dcc.dcc025.utils.ScreenUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Gabriel
 */
public class Login extends javax.swing.JFrame {

    private JPanel pnlPrincipal;
    private JTextField edtLogin;
    private JPasswordField edtSenha;
    
    private Usuario usuario;
    
    public Login() {        
        super("Login");      
        this.addWindowListener(new AtualizaDadosBase(this));
        initComponents();
    }

    private void initComponents() {
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
        btnLogin.addActionListener((ActionEvent arg) -> {
            Entrar();
        });        
        painelButton.add(btnLogin, BorderLayout.CENTER);  
        
        JButton btnCancelar = new JButton("Cancelar");    
        btnCancelar.addActionListener((ActionEvent arg) -> {
            Cancelar();
        });             
        painelButton.add(btnCancelar, BorderLayout.CENTER); 
                
        edtLogin = new JTextField(20);
        edtSenha = new JPasswordField(20);
        painelLoginField.add(edtLogin, BorderLayout.CENTER);
        painelSenhaField.add(edtSenha, BorderLayout.CENTER);
        
        painelButton.add(btnCancelar, BorderLayout.CENTER);  

        painelLogin.add(painelLoginField, BorderLayout.CENTER);
        painelLogin.add(painelSenhaField, BorderLayout.CENTER);
        painelLogin.add(painelButton, BorderLayout.CENTER);
        
        this.pnlPrincipal.add(painelLogin, BorderLayout.NORTH);
    }
    
    public void Entrar(){
        String login = edtLogin.getText().trim();
        String senha = Arrays.toString(edtSenha.getPassword()).trim();
        if(login.equals("") || senha.equals("")){
            JOptionPane.showMessageDialog(this, "login e/ou senha inválidos");
            return;
        }
            
        UsuarioRepository repository = new UsuarioRepository();
        usuario = repository.obterPorLoginSenha(login, senha);
        
        if(usuario == null){
            JOptionPane.showMessageDialog(this, "login e/ou senha inválidos");
            return;
        }            
        dispose();        
    }
    public void Cancelar(){
        usuario = null;
        dispose();
    }
    
    public Usuario Logar(){
        this.pack();
        this.setVisible(true);
        
        while(this.isShowing()){
            this.pack();
        }
        System.out.println("Nao ta mais");
        return usuario;            
    }

}

