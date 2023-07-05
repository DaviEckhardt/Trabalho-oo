package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.exception.EmailException;
import br.ufjf.dcc.dcc025.model.Categoria;
import br.ufjf.dcc.dcc025.model.Email;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.TipoUsuario;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class UsuarioCadastro extends CadastroBase implements IPesquisa<Equipe> { 
    private int id = 0;
    private JTextField edtNome;
    private JTextField edtEmail;
    private JPasswordField edtSenha;
    private JComboBox cbbCategoria;
    private int equipeId;   
    private TipoUsuario tipoUsuario;
    private JLabel lblEquipe;
    
    private final UsuarioRepository repository;
        
    public UsuarioCadastro(){
        this(null);
    }        
    public UsuarioCadastro(ListagemUsuario telaListagem){
        super("Cadastro de Usuário", telaListagem);
        repository = new UsuarioRepository();      
        equipeId = 0;
        tipoUsuario = TipoUsuario.Competidor;        
    } 
    
    public static void cadastrar(){
        cadastrar(null);
    }
    public static void cadastrar(ListagemUsuario listagem){
        UsuarioCadastro cadastro = new UsuarioCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
    }
    public static boolean editar(Usuario usuario){
        return editar(null, usuario);
    }
    public static boolean editar(ListagemUsuario listagem, Usuario usuario){
        UsuarioCadastro cadastro = new UsuarioCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
        cadastro.carregar(usuario);
        return true;
    }    
    
    @Override
    protected void desenhaTela() {
        JPanel painelTela;
        painelTela = new JPanel(new GridLayout(5, 2));
        
        JPanel painelNomeField = new JPanel(new GridLayout(2, 0));
        JPanel painelEmailField = new JPanel(new GridLayout(2, 0));
        JPanel painelSenhaField = new JPanel(new GridLayout(2, 0));
        JPanel painelCategoriaField = new JPanel(new GridLayout(2, 0));
        JPanel painelEquipeButton = new JPanel(new GridLayout(2, 1));
                
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
        
        lblEquipe = new JLabel();        
        lblEquipe.setVisible(false);
        JButton btnEscolherEquipe = new JButton("Escolher Equipe");
        btnEscolherEquipe.addActionListener((ActionEvent arg0) -> {
            ListagemEquipe.selecionar(this);
        });
        painelEquipeButton.add(lblEquipe, BorderLayout.NORTH);
        painelEquipeButton.add(btnEscolherEquipe, BorderLayout.SOUTH);
      
        painelTela.add(painelNomeField, BorderLayout.CENTER);
        painelTela.add(painelEmailField, BorderLayout.CENTER);        
        painelTela.add(painelSenhaField, BorderLayout.CENTER);
        painelTela.add(painelCategoriaField, BorderLayout.CENTER);
        painelTela.add(painelEquipeButton, BorderLayout.CENTER);        
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }


    @Override
    protected void salvar() {
        try {            
            Usuario usuario;            
            String nome = edtNome.getText();
            Email email = new Email(edtEmail.getText());
            String senha = new String(edtSenha.getPassword());
            Categoria categoria = (Categoria) cbbCategoria.getSelectedItem();           
            
            if(tipoUsuario == TipoUsuario.Administrador)
                usuario = Usuario.usuarioAdmin(id, nome, email, senha);
            else if(categoria == Categoria.Gerencia)
                usuario = Usuario.usuarioCapitao(id, nome, email, senha, equipeId);
            else
                usuario = Usuario.usuarioCompetidor(id, nome, email, senha, equipeId, categoria);
            
            repository.save(usuario);            
        } catch (EmailException ex) {
            // já protegido dentro do validar
        }
        
        this.setVisible(false);
        this.dispose();
    }

    @Override
    protected boolean validar() {
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

        if(equipeId <= 0 && tipoUsuario != TipoUsuario.Administrador){
            JOptionPane.showMessageDialog(this, "Equipe inválida!");
            return false;
        }
        
        if(id == 0 && repository.emailExiste(edtEmail.getText())){
            JOptionPane.showMessageDialog(this, "Esse email já foi utilizado!");
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
        tipoUsuario = usuario.getTipo();
        equipeId = usuario.getEquipeId();
        lblEquipe.setText("Equipe: " + equipeId); 
        lblEquipe.setVisible(equipeId > 0);
        this.repaint();
    }

    @Override
    public void receberPesquisa(Equipe equipe) {
        if(equipe != null){
            equipeId = equipe.getId();            
            lblEquipe.setText("Equipe: "  + equipe.getId()); 
            lblEquipe.setVisible(true);
        }            
        else{
            equipeId = 0;
            lblEquipe.setVisible(false);
        }            
        this.repaint();
    }
}
