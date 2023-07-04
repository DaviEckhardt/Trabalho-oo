/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.model.IPesquisa;
import br.ufjf.dcc.dcc025.view.ListagemBase;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gabriel
 */
public class AtualizaDadosListagem extends AtualizaDadosBase {
    private final ListagemBase listagem;
    private final IPesquisa telaDevolucao;
    public AtualizaDadosListagem(ListagemBase tela, IPesquisa telaDevolucao){
        super(tela);
        listagem = tela;
        this.telaDevolucao = telaDevolucao;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        listagem.Filtrar();
    }   
    
    @Override
    public void windowDeactivated(WindowEvent e) {
        if(telaDevolucao != null)
            telaDevolucao.ReceberPesquisa(listagem.itemSelecionado);
    }
}
