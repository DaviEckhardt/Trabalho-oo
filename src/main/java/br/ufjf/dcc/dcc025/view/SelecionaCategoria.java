/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.AtualizaDadosBase;
import br.ufjf.dcc.dcc025.model.Categoria;
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
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author ice
 */


public class SelecionaCategoria extends JFrame {
    public SelecionaCategoria() {
        setTitle("Painel de Categorias");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamanhoDaTela.width / 3, tamanhoDaTela.height / 3);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        JLabel label = new JLabel("Selecione uma categoria:");
        panel.add(label);

        JButton vsss = new JButton("VSSS");
        JButton seguidor = new JButton("Seguidor de Linha");
        JButton mini = new JButton("Mini Sumô");
        JButton lego = new JButton("Sumô Lego");
        JButton perseguidor = new JButton("Perseguidor de Linha");
        JButton spl = new JButton("SPL");
        JButton combate = new JButton("Combate");
        
        panel.add(vsss);
        panel.add(seguidor);
        panel.add(mini);
        panel.add(lego);
        panel.add(perseguidor);
        panel.add(spl);
        panel.add(combate);
        

        
        vsss.addActionListener((e) -> {
            Categoria categoria = Categoria.VSSS;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });
        
        seguidor.addActionListener((e) -> {
            Categoria categoria = Categoria.Seguidor;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });
        
        mini.addActionListener((e) -> {
            Categoria categoria = Categoria.MiniSumo;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });
        
        lego.addActionListener((e) -> {
            Categoria categoria = Categoria.SumoLego;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });

        perseguidor.addActionListener((e) -> {
            Categoria categoria = Categoria.Perseguidor;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });
        
        spl.addActionListener((e) -> {
            Categoria categoria = Categoria.SPL;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });
        
        combate.addActionListener((e) -> {
            Categoria categoria = Categoria.Combate;
            chav chaveamento = new chav(categoria);
            chaveamento.setVisible(true);
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelecionaCategoria().setVisible(true);
            }
        });
    }
}
