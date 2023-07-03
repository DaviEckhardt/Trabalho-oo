/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.model.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.IRepository;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class ListagemUsuario extends ListagemBase<Usuario> {

    private final UsuarioRepository repository;
    
    public ListagemUsuario(ModoTela modo){
        this(modo, null);
    }
    public ListagemUsuario(ModoTela modo, IPesquisa tela){
        super(modo, tela);
        repository = new UsuarioRepository();
    }
    
    public static void Selecionar(IPesquisa tela){
        ListagemUsuario listagem = new ListagemUsuario(ModoTela.Pesquisa, tela);
        listagem.exibir();
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
        Usuario usuarioLogado = LoginController.getUsuarioLogado();
        if(!usuarioLogado.permissaoCapitao() && !usuarioLogado.permissaoAdministrador() &&
                LoginController.getUsuarioLogado().getId() != item.getId()){
            JOptionPane.showMessageDialog(this, "Você não tem permissão para alterar esse usuário!");
            return false;
        }
            
        
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

    @Override
    protected boolean PreFiltro(Usuario item) {
        if(LoginController.getUsuarioLogado().permissaoAdministrador())
           return true;
        
        return LoginController.getUsuarioLogado().getEquipeId() == item.getEquipeId();
    }
    
}
