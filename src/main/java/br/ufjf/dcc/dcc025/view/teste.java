/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class teste extends JFrame {
    
    private Image imagemDeFundo;
    
    public teste() {
        super("Interface Gráfica com Imagem de Fundo");
        
        // Carrega a imagem de fundo
        imagemDeFundo = new ImageIcon("C:/Users/User/Documents/TrabalhoOO/Trabalho-oo/logorinoCOLLEGERe.png").getImage();
        
        // Configura o tamanho da janela
        Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamanhoDaTela.width/3, tamanhoDaTela.height/3);
        
        // Adiciona o painel personalizado à janela
        PainelComImagemDeFundo painel = new PainelComImagemDeFundo();
        setContentPane(painel);
    }
    
    // Painel personalizado com imagem de fundo
    private class PainelComImagemDeFundo extends JPanel {
        
        private JButton botaoBemVindo;
        
        public PainelComImagemDeFundo() {
            setLayout(new BorderLayout()); // Define o layout do painel como BorderLayout
            
            botaoBemVindo = new JButton("Bem vindo(a)");
            botaoBemVindo.setPreferredSize(new Dimension(10, 30));
            add(botaoBemVindo, BorderLayout.SOUTH);
            
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