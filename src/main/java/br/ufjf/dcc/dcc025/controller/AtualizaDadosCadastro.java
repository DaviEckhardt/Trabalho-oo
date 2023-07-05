package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.view.CadastroBase;
import br.ufjf.dcc.dcc025.view.ListagemBase;
import java.awt.event.WindowEvent;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
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
            listagem.filtrar();
    }
}
