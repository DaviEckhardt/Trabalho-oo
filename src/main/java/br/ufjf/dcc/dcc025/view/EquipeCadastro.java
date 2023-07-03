package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.repository.EquipeRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class EquipeCadastro extends CadastroBase {
    private int id = 0;
    private JTextField edtNome;
    private JTextField edtCidade;
    
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
        painelTela = new JPanel(new GridLayout(2, 1));
        
        JPanel painelNomeField = new JPanel(new GridLayout(0, 2));
        JPanel painelCidadeField = new JPanel(new GridLayout(0, 2));
                
        JLabel lblNome = new JLabel("Nome:");
        edtNome = new JTextField(20);
        painelNomeField.add(lblNome, BorderLayout.WEST);
        painelNomeField.add(edtNome, BorderLayout.EAST);
        
        JLabel lblCidade = new JLabel("Cidade:");
        edtCidade = new JTextField(60);
        painelCidadeField.add(lblCidade, BorderLayout.WEST);
        painelCidadeField.add(edtCidade, BorderLayout.EAST);
        
        painelTela.add(painelNomeField);
        painelTela.add(painelCidadeField);         
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }

    @Override
    protected void Salvar() {            
        String nome = edtNome.getText();
        String cidade = edtCidade.getText();            
        Equipe equipe = new Equipe(id, nome, cidade);            
        repository.save(equipe); 
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
                    
        return true;
    }

    private void carregar(Equipe equipe) {
        id = equipe.getId();
        edtNome.setText(equipe.getNome());
        edtCidade.setText(equipe.getCidade());
    }
    
}
