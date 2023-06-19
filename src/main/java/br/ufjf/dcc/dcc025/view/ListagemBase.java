package br.ufjf.dcc.dcc025.view;
import br.ufjf.dcc.dcc025.controller.AtualizaDadosListagem;
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
import br.ufjf.dcc.dcc025.utils.ImageUtils;
/**
 *
 * @author Gabriel
 * @param <T>
 */
public abstract class ListagemBase<T> extends JFrame {
    private final int VWIDTH = 800;
    private final int VHEIGHT = 600;
   
    protected abstract IRepository<T> getRepository();

    public ListagemBase() {
        super("Listagem");
        
        this.addWindowListener(new AtualizaDadosListagem(this));
        initComponents();
    }

    private void initComponents() {
        this.setResizable(false);
        this.setSize(VWIDTH,VHEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

        this.pnlPrincipal = new JPanel();
        this.pnlPrincipal.setLayout(new BorderLayout());

        desenhaPesquisa();
        desenhaGrid();
        desenhaRodape();
        this.add(this.pnlPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.repaint();
    }

    private void desenhaPesquisa() {
        JPanel painelPesquisa;
        painelPesquisa = new JPanel();
        painelPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
        painelPesquisa.setPreferredSize(new Dimension(VWIDTH, 50));
        
        JPanel painelTextField = new JPanel(new GridLayout(0, 1));
        JPanel painelButton = new JPanel(new GridLayout(0, 1));
        
        JButton btnPesquisa = new JButton();      
        btnPesquisa.setIcon(ImageUtils.CarregarImagem("search.png", 16, 16)); 
        
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
        //jItens.setPreferredSize(new Dimension(VWIDTH-200, VHEIGHT-200));
        jItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scroll = new JScrollPane(jItens);
        scroll.setPreferredSize(new Dimension(VWIDTH, VHEIGHT-100));
               
        painelGrid.add(scroll, BorderLayout.CENTER);
        
        pnlPrincipal.add(painelGrid, BorderLayout.CENTER);
    }

    private void desenhaRodape() {
        JPanel painelBotoes = new JPanel();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener((ActionEvent arg0) -> {
            Cadastrar();
        });
        painelBotoes.add(btnCadastrar, BorderLayout.EAST);
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener((ActionEvent arg0) -> {
            Editar();
        });
        painelBotoes.add(btnEditar, BorderLayout.EAST);
        
        JButton btnRemover = new JButton("Editar");
        btnRemover.addActionListener((ActionEvent arg0) -> {
            Remover();
        });
        painelBotoes.add(btnRemover, BorderLayout.EAST);
        
        pnlPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    protected abstract boolean Cadastrar();
    protected abstract boolean Editar();
    protected boolean Remover(){
        int index = jItens.getSelectedIndex();
        if(index != -1){
            T item = jItens.getModel().getElementAt(index);
            getRepository().remove(item);            
            return true;
        }
        return false;
    };
    public void Carregar(){         
        try {
            List<T> dados = getRepository().findAll();
            
            DefaultListModel<T> modelo = new DefaultListModel<>();
            
            for (T item : dados) {
                modelo.addElement(item);
            }
            
            this.jItens.setModel(modelo);
            this.repaint();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível carregar os dados!");
        }
    };

    
    public void exibir(){
        this.pack();
        this.setVisible(true);
    }
    private JTextField edtPesquisa;
    private JList<T> jItens;
    private JPanel pnlPrincipal;
}
