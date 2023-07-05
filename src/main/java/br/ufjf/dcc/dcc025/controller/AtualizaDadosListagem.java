package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.view.ListagemBase;
import java.awt.event.WindowEvent;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
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
        listagem.filtrar();
    }   
    
    @Override
    public void windowDeactivated(WindowEvent e) {
        if(telaDevolucao != null)
            telaDevolucao.receberPesquisa(listagem.itemSelecionado);
    }
}
