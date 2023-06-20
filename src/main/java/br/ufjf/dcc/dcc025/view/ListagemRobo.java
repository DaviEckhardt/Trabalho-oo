/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.repository.IRepository;
import br.ufjf.dcc.dcc025.repository.RoboRepository;

/**
 *
 * @author Gabriel
 */
public class ListagemRobo extends ListagemBase<Robo> {

    private final RoboRepository repository;
    
    public ListagemRobo(ModoTela modo){
        super(modo);
        repository = new RoboRepository();
    }
    
    public static Robo Selecionar(){
        ListagemRobo listagem = new ListagemRobo(ModoTela.Pesquisa);
        return listagem.selecionar();
    }
    
    public static void Exibir(){
        ListagemRobo listagem = new ListagemRobo(ModoTela.Listagem);
        listagem.exibir();
    }
    
    @Override
    protected IRepository<Robo> getRepository() {
        return repository;
    }

    @Override
    protected boolean Cadastrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected boolean Editar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
} 
