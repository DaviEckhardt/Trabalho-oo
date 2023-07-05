package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.Categoria;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.repository.EquipeRepository;
import br.ufjf.dcc.dcc025.repository.RoboRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class RoboCadastro extends CadastroBase implements IPesquisa<Equipe> { 
    private int id = 0;
    private JTextField edtNome;
    private JComboBox cbbCategoria;
    private JLabel lblEquipe;
    private Equipe equipe;   
    
    private final RoboRepository repository;
    
    public RoboCadastro(){
        this(null);
    }        
    public RoboCadastro(ListagemRobo telaListagem){
        super("Cadastro de Robo", telaListagem);
        repository = new RoboRepository();        
    }     
        
    public static void cadastrar(){
        cadastrar(null);
    }
    public static void cadastrar(ListagemRobo listagem){
        RoboCadastro cadastro = new RoboCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
    }
    public static boolean editar(Robo robo){
        return editar(null, robo);
    }
    public static boolean editar(ListagemRobo listagem, Robo robo){
        RoboCadastro cadastro = new RoboCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
        cadastro.carregar(robo);
        return true;
    }        
    
    @Override
    protected void desenhaTela() {
        JPanel painelTela;
        painelTela = new JPanel(new GridLayout(3, 2));
        
        JPanel painelNomeField = new JPanel(new GridLayout(2, 1));
        JPanel painelCategoriaField = new JPanel(new GridLayout(2, 1));
        JPanel painelEquipeButton = new JPanel(new GridLayout(2, 0));
                
        JLabel lblNome = new JLabel("Nome:");
        edtNome = new JTextField(20);
        painelNomeField.add(lblNome, BorderLayout.WEST);
        painelNomeField.add(edtNome, BorderLayout.EAST);
                
        JLabel lblCategoria = new JLabel("Categoria:");
        cbbCategoria = new JComboBox(Categoria.getCategoriasDisputa());
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
      
        painelTela.add(painelNomeField);
        painelTela.add(painelCategoriaField);
        painelTela.add(painelEquipeButton);        
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }


    @Override
    protected void salvar() {        
        String nome = edtNome.getText();
        Categoria categoria = (Categoria) cbbCategoria.getSelectedItem();           
        Robo robo = new Robo(id, nome, equipe.getId(), categoria);            
        repository.save(robo);    

        this.setVisible(false);
        this.dispose();        
    }

    @Override
    protected boolean validar() {
        if(edtNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome inválido!");
            return false;
        }
       
        if(cbbCategoria.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(this, "Categoria inválida!");
            return false;
        }

        if(equipe == null || equipe.getId() <= 0){
            JOptionPane.showMessageDialog(this, "Equipe inválida!");
            return false;
        }    
        
        if(id == 0 && repository.roboExiste(edtNome.getText(), (Categoria) cbbCategoria.getSelectedItem())){
            JOptionPane.showMessageDialog(this, "Esse nome já foi utilizado!");
            return false;
        }
        
        return true;
    }

    private void carregar(Robo robo) {
        id = robo.getId();
        edtNome.setText(robo.getNome());
        cbbCategoria.setSelectedItem(robo.getCategoria());
        if(robo.getEquipeId() > 0){
            EquipeRepository equipeRepo = new EquipeRepository();
            equipe = equipeRepo.getById(robo.getEquipeId());
            
            lblEquipe.setText("Equipe: " + equipe != null ? equipe.getNome() : ""); 
            lblEquipe.setVisible(equipe != null);
            this.repaint();
        }       
    }     

    @Override
    public void receberPesquisa(Equipe equipe) {
        this.equipe = equipe;        
        lblEquipe.setText("Equipe: " + equipe != null ? equipe.getNome() : ""); 
        lblEquipe.setVisible(equipe != null);
        this.repaint();
    }
}
