/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.utils.ScreenUtils;
import br.ufjf.dcc.dcc025.view.ListagemBase;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Gabriel
 */
public class AtualizaDadosListagem extends AtualizaDadosBase {
    private ListagemBase listagem;
    
    public AtualizaDadosListagem(ListagemBase tela){
        super(tela);
        listagem = tela;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        listagem.Filtrar();
    }        
}
