package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosCadastro;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public abstract class CadastroBase extends JFrame{
    
    protected JPanel pnlPrincipal;
    
    public CadastroBase(String title){
        this(title, null);
    }    
    
    public CadastroBase(String title, ListagemBase telaListagem){
        super(title);      
        this.addWindowListener(new AtualizaDadosCadastro(this, telaListagem));
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
    }
    protected abstract void desenhaTela();

    private void desenhaRodape() {
        JPanel painelBotoes = new JPanel();
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener((ActionEvent arg0) -> {
            salvarBase();
        });
        painelBotoes.add(btnSalvar, BorderLayout.EAST);       
             
        pnlPrincipal.add(painelBotoes, BorderLayout.SOUTH);    
    }

    private void salvarBase() {
        if(!validar())
            return;
        
        salvar();        
        this.setVisible(false);
        this.dispose();        
    }

    protected abstract boolean validar();
    protected abstract void salvar();
}
