/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.utils.ScreenUtils;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Gabriel
 */
public class AtualizaDadosBase implements WindowListener {

    private Window tela;
    public AtualizaDadosBase(Window tela){
        this.tela = tela;
    }
    @Override
    public void windowOpened(WindowEvent e) {
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
        ScreenUtils.formWindowCenter(tela);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
