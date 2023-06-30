/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.IRepository;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;

/**
 *
 * @author Gabriel
 */
public class ListagemUsuario extends ListagemBase<Usuario> {

    private final UsuarioRepository repository;
    
    public ListagemUsuario(ModoTela modo){
        super(modo);
        repository = new UsuarioRepository();
    }
    
    public static Usuario Selecionar(){
        ListagemUsuario listagem = new ListagemUsuario(ModoTela.Pesquisa);
        return listagem.selecionar();
    }
    
    public static void Exibir(){
        ListagemUsuario listagem = new ListagemUsuario(ModoTela.Listagem);
        listagem.exibir();
    }
    
    @Override
    protected IRepository<Usuario> getRepository() {
        return repository;
    }

    @Override
    protected boolean Cadastrar() {
        try{
            UsuarioCadastro.Cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }        
    }

    @Override
    protected boolean Editar(Usuario item) {
        try{
            UsuarioCadastro.Editar(this,item);
            return true;
        }
        catch(Exception e) {
            return false;
        }   
    }

    @Override
    protected boolean PermissaoRemover() {
        return LoginController.getUsuarioLogado().permissaoAdministrador();
    }
    
}
