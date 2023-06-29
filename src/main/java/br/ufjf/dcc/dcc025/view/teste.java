/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class teste extends JFrame {

    private Image imagemDeFundo;

    public teste() {
        super("Interface Gráfica com Imagem de Fundo");
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

        private JButton botaoBemVindo;

        public PainelComImagem() {
            setLayout(new BorderLayout()); // Define o layout do painel como BorderLayout

            
            //botaoBemVindo.setPreferredSize(new Dimension(50, 30));
            botaoBemVindo = new JButton("Sair");
            JPanel painel = new JPanel();
            painel.setLayout(new GridLayout(2,1));
            
            JButton equipes = new JButton("Lista de Equipes");
            JButton robos = new JButton("Lista de Robôs");
            JButton participantes = new JButton("Lista de Participantes");
            JButton chave = new JButton("Ver o chaveamento");
            
            
            equipes.addActionListener((e) -> {
                ListagemEquipe.Exibir();
            }); 
            
            robos.addActionListener((e) -> {
                ListagemRobo.Exibir();
            });  
            
            participantes.addActionListener((e) -> {
                ListagemUsuario.Exibir();
            });
            
            chave.addActionListener( (e)-> {
                chav chaveamento = new chav();
                chaveamento.setVisible(true);
            });
                    
                    
            painel.add(equipes);
            painel.add(robos);
            painel.add(participantes);
            painel.add(chave);  
            painel.add(botaoBemVindo); 

            
            add(painel, BorderLayout.SOUTH);

            botaoBemVindo.addActionListener((ActionEvent e) -> {
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Desenha a imagem de fundo
            g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);
            }
    }

    public static void main(String[] args) {
            teste janela = new teste();
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setVisible(true);
    }
}
