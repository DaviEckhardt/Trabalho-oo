/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.view.Chaveamento;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gabriel
 */
public class AtualizaDadosCampeonato extends AtualizaDadosBase {
    
    private final Chaveamento tela;
    public AtualizaDadosCampeonato(Chaveamento tela) {
        super(tela);
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        tela.carregar();
    }  
}
