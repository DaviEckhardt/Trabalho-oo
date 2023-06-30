/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.repository.EquipeRepository;
import br.ufjf.dcc.dcc025.repository.IRepository;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gabriel
 */
public class ListagemEquipe extends ListagemBase<Equipe> {

    private final EquipeRepository repository;
    
    public ListagemEquipe(ModoTela modo){
        super(modo);
        repository = new EquipeRepository();
    }
    
    public static Equipe Selecionar(){
        ListagemEquipe listagem = new ListagemEquipe(ModoTela.Pesquisa);
        listagem.selecionar();                    
        return listagem.itemSelecionado;
    }
    
    public static void Exibir(){
        ListagemEquipe listagem = new ListagemEquipe(ModoTela.Listagem);
        listagem.exibir();
    }
    @Override
    protected IRepository<Equipe> getRepository() {
        return repository;
    }

    @Override
    protected boolean Cadastrar() {
        try{
            EquipeCadastro.Cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }  
    }

    @Override
    protected boolean Editar(Equipe item) {
        try{
            EquipeCadastro.Editar(this, item);
            return true;
        }
        catch(Exception e) {
            return false;
        }  
    }

    @Override
    protected boolean PermissaoRemover() {
        return LoginController.getUsuarioLogado().permissaoAdministrador() || LoginController.getUsuarioLogado().permissaoCapitao();
    }
    
}
