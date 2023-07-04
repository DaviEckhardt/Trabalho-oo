package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.model.IPesquisa;
import br.ufjf.dcc.dcc025.model.TipoUsuario;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.EquipeRepository;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class EquipeCadastro extends CadastroBase implements IPesquisa<Usuario>{
    private int id = 0;
    private JTextField edtNome;
    private JTextField edtCidade;
    private int capitaoId = 0;
    
    private final EquipeRepository repository;
    
    public EquipeCadastro(){
        this(null);
    }        
    public EquipeCadastro(ListagemEquipe telaListagem){
        super("Cadastro de Equipe", telaListagem);
        repository = new EquipeRepository();        
    } 
    
    public static void Cadastrar(){
        Cadastrar(null);
    }
    public static void Cadastrar(ListagemEquipe listagem){
        EquipeCadastro cadastro = new EquipeCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
    }
    public static boolean Editar(Equipe equipe){
        return Editar(null, equipe);
    }
    public static boolean Editar(ListagemEquipe listagem, Equipe equipe){
        EquipeCadastro cadastro = new EquipeCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
        cadastro.carregar(equipe);
        return true;
    }    
    
    @Override
    protected void desenhaTela() {
        JPanel painelTela;
        painelTela = new JPanel(new GridLayout(3, 1));
        
        JPanel painelNomeField = new JPanel(new GridLayout(2, 0));
        JPanel painelCidadeField = new JPanel(new GridLayout(2, 0));
        JPanel painelCapitao = new JPanel(new GridLayout(1, 0));
        
        JLabel lblNome = new JLabel("Nome:");
        edtNome = new JTextField(20);
        painelNomeField.add(lblNome, BorderLayout.WEST);
        painelNomeField.add(edtNome, BorderLayout.EAST);
        
        JLabel lblCidade = new JLabel("Cidade:");
        edtCidade = new JTextField(40);
        painelCidadeField.add(lblCidade, BorderLayout.WEST);
        painelCidadeField.add(edtCidade, BorderLayout.EAST);
        
        if(id == 0){
            JButton btnSalvar = new JButton("Selecionar Capitão");
            btnSalvar.addActionListener((ActionEvent arg0) -> {
                ListagemUsuario.Selecionar(this);
            });        
            painelCapitao.add(btnSalvar, BorderLayout.CENTER);    
        }        
        painelTela.add(painelNomeField);
        painelTela.add(painelCidadeField);         
        painelTela.add(painelCapitao, BorderLayout.SOUTH); 
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }

    @Override
    protected void Salvar() {            
        String nome = edtNome.getText();
        String cidade = edtCidade.getText();            
        Equipe equipe = new Equipe(id, nome, cidade);            
        repository.save(equipe); 
        
        if(capitaoId > 0){
            UsuarioRepository usuarioRepository = new UsuarioRepository();
            Usuario usuario = usuarioRepository.getById(capitaoId);    
            usuario = Usuario.UsuarioCapitao(usuario.getId(), usuario.getNome(), usuario.getEmailClass(), usuario.getSenha(), equipe.getId());
            usuarioRepository.save(usuario);
        }        
    }
    @Override
    protected boolean Validar() {
        if(edtNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome inválido!");
            return false;
        }
                
        if(edtCidade.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Cidade inválida!");
            return false;
        }
                  
        if(id == 0 && repository.equipeExiste(edtNome.getText(), edtCidade.getText())){
            JOptionPane.showMessageDialog(this, "Equipe já cadastrada!");
            return false;
        }
        
        if(id == 0 && capitaoId == 0){
            JOptionPane.showMessageDialog(this, "Selecione um capitão para continuar!");
            return false;
        }
            
        return true;
    }

    private void carregar(Equipe equipe) {
        id = equipe.getId();
        edtNome.setText(equipe.getNome());
        edtCidade.setText(equipe.getCidade());        
    }

    @Override
    public void ReceberPesquisa(Usuario item) {
        if(item != null)
            capitaoId = item.getId();
    }
    
}
