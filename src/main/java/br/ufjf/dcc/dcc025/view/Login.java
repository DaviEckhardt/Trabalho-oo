package br.ufjf.dcc.dcc025.view;
import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.repaint();

        this.setVisible(true);
    }

    private void desenhaTela() {
        JPanel painelLogin;
        painelLogin = new JPanel();
        //painelLogin.setPreferredSize(new Dimension(VWIDTH, 50));
        
        JPanel painelLoginField = new JPanel(new GridLayout(2, 1));
        JPanel painelSenhaField = new JPanel(new GridLayout(2, 1));
        JPanel painelButton = new JPanel(new GridLayout(0, 2));
        
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
        
        JLabel labelLogin = new JLabel("Email ou login");
        JLabel labelSenha = new JLabel("Senha");
        painelLoginField.add(labelLogin, BorderLayout.NORTH);
        painelLoginField.add(edtLogin, BorderLayout.CENTER);
        painelSenhaField.add(labelSenha, BorderLayout.NORTH);
        painelSenhaField.add(edtSenha, BorderLayout.CENTER);
        
        painelButton.add(btnCancelar, BorderLayout.CENTER);  

        painelLogin.add(painelLoginField, BorderLayout.CENTER);
        painelLogin.add(painelSenhaField, BorderLayout.CENTER);
        painelLogin.add(painelButton, BorderLayout.CENTER);
        
        this.pnlPrincipal.add(painelLogin, BorderLayout.NORTH);
    }
    
    public void Entrar(){
        String login = edtLogin.getText().trim();
        String senha = new String(edtSenha.getPassword());
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
            this.repaint();
        }
        System.out.println(usuario);
        return usuario;            
    }

}

