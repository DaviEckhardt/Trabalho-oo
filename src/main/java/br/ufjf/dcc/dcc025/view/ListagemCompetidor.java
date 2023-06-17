/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.Competidor;
import br.ufjf.dcc.dcc025.repository.CompetidorRepository;
import br.ufjf.dcc.dcc025.repository.IRepository;

/**
 *
 * @author Gabriel
 */
public class ListagemCompetidor extends ListagemBase<Competidor> {

    private final CompetidorRepository repository;
    
    public ListagemCompetidor(){
        repository = new CompetidorRepository();
    }
    @Override
    protected IRepository<Competidor> getRepository() {
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
