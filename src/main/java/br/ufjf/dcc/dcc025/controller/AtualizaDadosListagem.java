/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.view.ListagemBase;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Gabriel
 */
public class AtualizaDadosListagem implements WindowListener{
    private ListagemBase listagem;
    
    public AtualizaDadosListagem(ListagemBase tela){
        listagem = tela;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        listagem.Carregar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
