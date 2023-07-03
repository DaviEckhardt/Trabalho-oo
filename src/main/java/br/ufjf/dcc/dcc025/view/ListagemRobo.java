package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.model.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.IRepository;
import br.ufjf.dcc.dcc025.repository.RoboRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class ListagemRobo extends ListagemBase<Robo> {

    private final RoboRepository repository;
    
    public ListagemRobo(ModoTela modo){
        this(modo, null);
    }
    public ListagemRobo(ModoTela modo, IPesquisa tela){
        super(modo, tela);
        repository = new RoboRepository();
    }
    
    public static void Selecionar(IPesquisa tela){
        ListagemRobo listagem = new ListagemRobo(ModoTela.Pesquisa, tela);
        listagem.exibir();
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
        try{
            RoboCadastro.Cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }  
    }

    @Override
    protected boolean Editar(Robo item) {
        Usuario usuarioLogado = LoginController.getUsuarioLogado();
        if(!usuarioLogado.permissaoCapitao() && !usuarioLogado.permissaoAdministrador()){
            JOptionPane.showMessageDialog(this, "Você não tem permissão para alterar esse usuário!");
            return false;
        }
        try{
            RoboCadastro.Editar(this,item);
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

    @Override
    protected boolean PreFiltro(Robo item) {
        if(LoginController.getUsuarioLogado().permissaoAdministrador())
           return true;
        
        return LoginController.getUsuarioLogado().getEquipeId() == item.getEquipeId();
    }
} 
