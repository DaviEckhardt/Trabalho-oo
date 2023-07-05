package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import br.ufjf.dcc.dcc025.model.Categoria;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JLabel;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class SelecionaCategoria extends JFrame {
    public SelecionaCategoria() {
        setTitle("Painel de Categorias");
        this.addWindowListener(new AtualizaDadosBase(this));
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamanhoDaTela.width / 3, tamanhoDaTela.height / 3);
        
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Selecione uma categoria:");
        panel.add(label);

        int rows = 1;
        for (Categoria categoria : Categoria.values()) {
            if(!categoria.getTemDisputa())
                continue;
            
            JButton button = new JButton(categoria.getNome());
            
            button.addActionListener((e) -> {
                Chaveamento chaveamento = new Chaveamento(categoria);
                chaveamento.setVisible(true);
                dispose();
            });
            rows++;
            panel.add(button);
        }

        panel.setLayout(new GridLayout(rows, 1));
        add(panel);
        setVisible(true);
    }    
}
