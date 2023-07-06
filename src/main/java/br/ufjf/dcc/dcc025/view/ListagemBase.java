package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosListagem;
import br.ufjf.dcc.dcc025.interfaces.IEntidadeRepository;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import br.ufjf.dcc.dcc025.repository.IRepository;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public abstract class ListagemBase<T extends IEntidadeRepository> extends JFrame {
    private final int VWIDTH = 800;
    private final int VHEIGHT = 600;
   
    protected abstract IRepository<T> getRepository();
    protected abstract boolean cadastrar();
    protected abstract boolean editar(T item);
    protected abstract boolean permissaoRemover();
    protected abstract boolean preFiltro(T item);
    public ModoTela Modo;
    
    public T itemSelecionado;
    
    public ListagemBase(ModoTela modo, IPesquisa telaPesquisa) {
        super(modo == ModoTela.Listagem ? "Listagem" : "Pesquisa");
        this.Modo = modo;
        this.addWindowListener(new AtualizaDadosListagem(this, telaPesquisa));
        initComponents();
    }
    
    private void initComponents() {
        this.setResizable(false);
        this.setSize(VWIDTH,VHEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       

        this.pnlPrincipal = new JPanel();
        this.pnlPrincipal.setLayout(new BorderLayout());

        desenhaPesquisa();
        desenhaGrid();
        desenhaRodape();
        this.add(this.pnlPrincipal);
        this.repaint();
    }

    private void desenhaPesquisa() {
        JPanel painelPesquisa;
        painelPesquisa = new JPanel();
        painelPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
        painelPesquisa.setPreferredSize(new Dimension(VWIDTH, 50));
        
        JPanel painelTextField = new JPanel(new GridLayout(0, 1));
        JPanel painelButton = new JPanel(new GridLayout(0, 1));
        
        JButton btnPesquisa = new JButton("Pesquisar");      
        btnPesquisa.addActionListener((ActionEvent arg0) -> {
            filtrar();
        });
        edtPesquisa = new JTextField(40);
        painelTextField.add(edtPesquisa, BorderLayout.CENTER);
        painelButton.add(btnPesquisa, BorderLayout.EAST);        
        painelPesquisa.add(painelTextField, BorderLayout.CENTER);
        painelPesquisa.add(painelButton, BorderLayout.EAST);
        
        this.pnlPrincipal.add(painelPesquisa, BorderLayout.NORTH);
    }

    private void desenhaGrid() {
        JPanel painelGrid = new JPanel();
        painelGrid.setPreferredSize(new Dimension(VWIDTH, VHEIGHT-100));
        DefaultListModel<T> model = new DefaultListModel<>();
        
        jItens = new JList<>(model);
        jItens.setVisible(true);
        jItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scroll = new JScrollPane(jItens);
        scroll.setPreferredSize(new Dimension(VWIDTH, VHEIGHT-100));
               
        painelGrid.add(scroll, BorderLayout.CENTER);
        
        pnlPrincipal.add(painelGrid, BorderLayout.CENTER);
    }

    private void desenhaRodape() {
        JPanel painelBotoes = new JPanel(new GridLayout(0, Modo == ModoTela.Listagem ? 3 : 4));

        if(Modo == ModoTela.Pesquisa){
            JButton btnSelecionar = new JButton("Selecionar");
            btnSelecionar.addActionListener((ActionEvent arg0) -> {
                escolher();
            });
            painelBotoes.add(btnSelecionar, BorderLayout.EAST);
            this.repaint();
        }
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener((ActionEvent arg0) -> {
            if(cadastrar())
                filtrar();
        });
        painelBotoes.add(btnCadastrar, BorderLayout.EAST);
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener((ActionEvent arg0) -> {
            editar();
        });
        painelBotoes.add(btnEditar, BorderLayout.EAST);
        
        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener((ActionEvent arg0) -> {
            remover();
        });
        painelBotoes.add(btnRemover, BorderLayout.EAST);
                
        pnlPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }
    

    protected boolean remover(){
        if(!permissaoRemover()){
            JOptionPane.showMessageDialog(this, "Você não possui permissão para remover!");
            return false;
        }
        
        int index = jItens.getSelectedIndex();
        if(index != -1){
            T item = jItens.getModel().getElementAt(index);
            getRepository().remove(item); 
            filtrar();
            return true;
        }
        return false;
    };
    
    protected void escolher(){
        int index = jItens.getSelectedIndex();
        if(index != -1){
            itemSelecionado = jItens.getModel().getElementAt(index);
            this.dispose();
        }  
        else
            JOptionPane.showMessageDialog(this, "Selecione um item!");
    };

    public void carregar(String filtro){         
        try {
            List<T> dados = getRepository().findAll();
            DefaultListModel<T> modelo = new DefaultListModel<>();
            
            for (T item : dados) {
                if(preFiltro(item) && (filtro.isBlank() || item.toString().contains(filtro)))
                    modelo.addElement(item);
            }
            
            this.jItens.setModel(modelo);
            this.repaint();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível carregar os dados!");
        }
    };
    
    protected void mostrar(){
        this.pack();
        this.setVisible(true);
    }
   
    private JTextField edtPesquisa;
    private JList<T> jItens;
    private JPanel pnlPrincipal;

    public void filtrar() {
        carregar(edtPesquisa.getText());
    }

    private void editar() {
        int index = jItens.getSelectedIndex();
        if(index != -1)
            editar(jItens.getModel().getElementAt(index));
        else
            JOptionPane.showMessageDialog(this, "Selecione um item para editar!");
        
        filtrar();
    }
}
