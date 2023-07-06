package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.interfaces.IRepository;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import javax.swing.JOptionPane;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
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
    
    public static void selecionar(IPesquisa tela){
        ListagemUsuario listagem = new ListagemUsuario(ModoTela.Pesquisa, tela);
        listagem.mostrar();
    }
    
    public static void exibir(){
        ListagemUsuario listagem = new ListagemUsuario(ModoTela.Listagem);
        listagem.mostrar();
    }
    
    @Override
    protected IRepository<Usuario> getRepository() {
        return repository;
    }

    @Override
    protected boolean cadastrar() {
        try{
            UsuarioCadastro.cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }        
    }

    @Override
    protected boolean editar(Usuario item) {
        Usuario usuarioLogado = LoginController.getUsuarioLogado();
        if(!usuarioLogado.permissaoCapitao() && !usuarioLogado.permissaoAdministrador() &&
                LoginController.getUsuarioLogado().getId() != item.getId()){
            JOptionPane.showMessageDialog(this, "Você não tem permissão para alterar esse usuário!");
            return false;
        }
            
        
        try{
            UsuarioCadastro.editar(this,item);
            return true;
        }
        catch(Exception e) {
            return false;
        }   
    }

    @Override
    protected boolean permissaoRemover() {
        return LoginController.getUsuarioLogado().permissaoAdministrador();
    }

    @Override
    protected boolean preFiltro(Usuario item) {
        if(LoginController.getUsuarioLogado().permissaoAdministrador())
           return true;
        
        return LoginController.getUsuarioLogado().getEquipeId() == item.getEquipeId();
    }
    
}
