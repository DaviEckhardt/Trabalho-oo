package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.*;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class Menu extends JFrame {

    private final Image imagemDeFundo;

    public Menu() {
        super("Menu");
        addWindowListener(new AtualizaDadosBase(this));
        // Carrega a imagem de fundo
        imagemDeFundo = new ImageIcon("src/Imagens/logorinoCOLLEGERe.png").getImage();
 
        File file = new File("src/Imagens/logorinoCOLLEGERe.png");
        // Configura o tamanho da janela
        Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamanhoDaTela.width / 2, tamanhoDaTela.height / 2);

        // Adiciona o painel personalizado à janela
        PainelComImagem painel = new PainelComImagem();
        setContentPane(painel);
    }

    // Painel personalizado com imagem de fundo
    private class PainelComImagem extends JPanel {


        public PainelComImagem() {
            setLayout(new BorderLayout()); // Define o layout do painel como BorderLayout

            
            //botaoBemVindo.setPreferredSize(new Dimension(50, 30));
            JButton botaoSair = new JButton("Sair");
            JPanel painel = new JPanel();
            painel.setLayout(new GridLayout(2,1));
            
            JButton participantes = new JButton("Lista de Participantes");
            JButton equipes = new JButton("Lista de Equipes");
            JButton robos = new JButton("Lista de Robôs");
            JButton pecas = new JButton("Lista de Peças");
            JButton chave = new JButton("Ver o chaveamento");
            
            
            equipes.addActionListener((e) -> {
                ListagemEquipe.exibir();
            }); 
            
            robos.addActionListener((e) -> {
                ListagemRobo.exibir();
            });  
            
            participantes.addActionListener((e) -> {
                ListagemUsuario.exibir();
            });
            
            pecas.addActionListener((e) -> {
                ListagemPeca.exibir();
            });
            chave.addActionListener( (e)-> {
                SelecionaCategoria sel = new SelecionaCategoria();
                sel.setVisible(true);
            });
                    
                    
            painel.add(participantes);
            painel.add(equipes);
            painel.add(robos);
            painel.add(pecas);
            painel.add(chave);  
            painel.add(botaoSair); 
            
            add(painel, BorderLayout.SOUTH);

            botaoSair.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Desenha a imagem de fundo
            g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);
            }
    }
}
