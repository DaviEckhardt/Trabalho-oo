package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.Peca;
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.repository.PecaRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class PecaCadastro extends CadastroBase implements IPesquisa<Robo> { 
    private int id = 0;
    private JTextField edtNome;
    private JSpinner edtValor;
    private JSpinner edtQuantidade;
    private JLabel lblRobo;
    private int roboId;
    private int equipeId;
    
    private final PecaRepository repository;
    
    public PecaCadastro(){
        this(null);
    }        
    public PecaCadastro(ListagemPeca telaListagem){
        super("Cadastro de Peças", telaListagem);
        repository = new PecaRepository();        
    }     
        
    public static void cadastrar(){
        cadastrar(null);
    }
    public static void cadastrar(ListagemPeca listagem){
        PecaCadastro cadastro = new PecaCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
    }
    public static boolean editar(Peca peca){
        return editar(null, peca);
    }
    public static boolean editar(ListagemPeca listagem, Peca peca){
        PecaCadastro cadastro = new PecaCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
        cadastro.carregar(peca);
        return true;
    }        
    
    @Override
    protected void desenhaTela() {
        JPanel painelTela;
        painelTela = new JPanel(new GridLayout(4, 2));
        
        JPanel painelNomeField = new JPanel(new GridLayout(2, 1));
        JPanel painelValorField = new JPanel(new GridLayout(2, 1));
        JPanel painelQuantidadeField = new JPanel(new GridLayout(2, 1));
        JPanel painelEscolherRobo = new JPanel(new GridLayout(2, 0));
                
        JLabel lblNome = new JLabel("Nome:");
        edtNome = new JTextField(20);
        painelNomeField.add(lblNome, BorderLayout.NORTH);
        painelNomeField.add(edtNome, BorderLayout.SOUTH);
                
        JLabel lblValor = new JLabel("Valor:");
        edtValor = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        painelValorField.add(lblValor, BorderLayout.NORTH);
        painelValorField.add(edtValor, BorderLayout.SOUTH);
        
        JLabel lblQuantidade = new JLabel("Quantidade:");
        edtQuantidade = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        painelQuantidadeField.add(lblQuantidade, BorderLayout.NORTH);
        painelQuantidadeField.add(edtQuantidade, BorderLayout.SOUTH);
        
        lblRobo = new JLabel();        
        lblRobo.setVisible(false);
        JButton btnEscolherRobo = new JButton("Escolher Robô");
        btnEscolherRobo.addActionListener((ActionEvent arg0) -> {
            ListagemRobo.selecionar(this);
        });
        painelEscolherRobo.add(lblRobo, BorderLayout.NORTH);
        painelEscolherRobo.add(btnEscolherRobo, BorderLayout.SOUTH);
      
        painelTela.add(painelNomeField);
        painelTela.add(painelValorField);
        painelTela.add(painelQuantidadeField);        
        painelTela.add(painelEscolherRobo);   
        
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }


    @Override
    protected void salvar() {        
        String nome = edtNome.getText();
        int valor = (int)edtValor.getValue();
        int quantidade = (int)edtQuantidade.getValue();
        
        Peca peca = new Peca(id, nome, valor, quantidade, roboId, equipeId);            
        repository.save(peca);    
    }

    @Override
    protected boolean validar() {
        if(edtNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome inválido!");
            return false;
        }
       
        if((int)edtValor.getValue() <= 0){
            JOptionPane.showMessageDialog(this, "Valor inválido!");
            return false;
        }

        if((int)edtQuantidade.getValue() < 0){
            JOptionPane.showMessageDialog(this, "Quantidade inválida!");
            return false;
        }    
        
        if(roboId == 0){
            JOptionPane.showMessageDialog(this, "Selecione um robô para a peça!");
            return false;
        }
        
        return true;
    }

    private void carregar(Peca peca) {
        id = peca.getId();
        roboId = peca.getRoboId();
        equipeId = peca.getEquipeId();        
        edtNome.setText(peca.getNome());
        edtValor.setValue(peca.getValor());
        edtQuantidade.setValue(peca.getQuantidade());
        lblRobo.setText("Robo: " + this.roboId); 
        lblRobo.setVisible(true);
        this.repaint();
    }     

    @Override
    public void receberPesquisa(Robo robo) {
        if(robo!= null){
            this.roboId = robo.getId();      
            this.equipeId = robo.getEquipeId();            
            lblRobo.setText("Robo: " + this.roboId); 
            lblRobo.setVisible(true);
        }
        else
            lblRobo.setVisible(false);
        
        this.repaint();
    }
}

