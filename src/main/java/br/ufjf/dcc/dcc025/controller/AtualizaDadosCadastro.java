/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.view.CadastroBase;
import br.ufjf.dcc.dcc025.view.ListagemBase;
import java.awt.Window;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gabriel
 */
public class AtualizaDadosCadastro extends AtualizaDadosBase {
    private ListagemBase listagem;
    
    public AtualizaDadosCadastro(CadastroBase tela) {
        this(tela, null);
    }
    public AtualizaDadosCadastro(CadastroBase tela, ListagemBase listagem) {
        super(tela);
        this.listagem = listagem;
    }
    
    @Override
    public void windowDeactivated(WindowEvent e) {
        if(listagem != null)
            listagem.Filtrar();
    }
}
