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
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.RoboRepository;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class RoboCadastro extends CadastroBase { 
    private int id = 0;
    private JTextField edtNome;
    private JComboBox cbbCategoria;
    private int equipeId;   
    
    private final RoboRepository repository;
    
    public RoboCadastro(){
        this(null);
    }        
    public RoboCadastro(ListagemRobo telaListagem){
        super("Cadastro de Robo", telaListagem);
        repository = new RoboRepository();        
    }     
        
    public static void Cadastrar(){
        Cadastrar(null);
    }
    public static void Cadastrar(ListagemRobo listagem){
        RoboCadastro cadastro = new RoboCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
    }
    public static boolean Editar(Robo robo){
        return Editar(null, robo);
    }
    public static boolean Editar(ListagemRobo listagem, Robo robo){
        RoboCadastro cadastro = new RoboCadastro(listagem);        
        cadastro.pack();
        cadastro.setVisible(true);
        cadastro.carregar(robo);
        return true;
    }        
    
    @Override
    protected void desenhaTela() {
        JPanel painelTela;
        painelTela = new JPanel(new GridLayout(0, 2));
        
        JPanel painelNomeField = new JPanel(new GridLayout(0, 2));
        JPanel painelCategoriaField = new JPanel(new GridLayout(1, 1));
        JPanel painelEquipeButton = new JPanel(new GridLayout(0, 1));
                
        JLabel lblNome = new JLabel("Nome:");
        edtNome = new JTextField(20);
        painelNomeField.add(lblNome, BorderLayout.WEST);
        painelNomeField.add(edtNome, BorderLayout.EAST);
                
        JLabel lblCategoria = new JLabel("Categoria:");
        cbbCategoria = new JComboBox(Categoria.values());
        painelCategoriaField.add(lblCategoria, BorderLayout.WEST);
        painelCategoriaField.add(cbbCategoria, BorderLayout.EAST);
        
        JButton btnEscolherEquipe = new JButton("Escolher Equipe");
        btnEscolherEquipe.addActionListener((ActionEvent arg0) -> {
            EscolherEquipe();
        });
        painelEquipeButton.add(btnEscolherEquipe, BorderLayout.EAST);
      
        painelTela.add(painelNomeField);
        painelTela.add(painelCategoriaField);
        painelTela.add(painelEquipeButton);        
        this.pnlPrincipal.add(painelTela, BorderLayout.CENTER);
    }


    @Override
    protected void Salvar() {
        if(!Validar())
            return;
        
        String nome = edtNome.getText();
        Categoria categoria = (Categoria) cbbCategoria.getSelectedItem();           
        Robo robo = new Robo(id, nome, equipeId, categoria);            
        repository.save(robo);    

        this.setVisible(false);
        this.dispose();        
    }

    private void EscolherEquipe() {
        Equipe equipe = ListagemEquipe.Selecionar();
        
        if(equipe != null)
            equipeId = equipe.getId();
        else
            equipeId = 0;
    }

    @Override
    protected boolean Validar() {
        if(edtNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome inválido!");
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

    private void carregar(Robo robo) {
        id = robo.getId();
        edtNome.setText(robo.getNome());
        cbbCategoria.setSelectedItem(robo.getCategoria());
        equipeId = robo.getEquipeId();
    }     
}
