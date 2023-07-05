package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.view.Chaveamento;
import java.awt.event.WindowEvent;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
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
