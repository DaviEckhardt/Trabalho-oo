package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Peca;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.IRepository;
import br.ufjf.dcc.dcc025.repository.PecaRepository;
import javax.swing.JOptionPane;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class ListagemPeca extends ListagemBase<Peca>  {

    private final PecaRepository repository;
    
    public ListagemPeca(ModoTela modo){
        this(modo, null);
    }
    
    public ListagemPeca(ModoTela modo, IPesquisa tela){
        super(modo, tela);
        repository = new PecaRepository();
    }
    
    public static void selecionar(IPesquisa tela){
        ListagemPeca listagem = new ListagemPeca(ModoTela.Pesquisa, tela);
        listagem.mostrar();
    }
    
    public static void exibir(){
        ListagemPeca listagem = new ListagemPeca(ModoTela.Listagem);
        listagem.mostrar();
    }
    
    @Override
    protected IRepository<Peca> getRepository() {
        return repository;
    }

    @Override
    protected boolean cadastrar() {
        try{
            PecaCadastro.cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }  
    }

    @Override
    protected boolean editar(Peca item) {
        Usuario usuarioLogado = LoginController.getUsuarioLogado();
        if(!usuarioLogado.permissaoCapitao() && !usuarioLogado.permissaoAdministrador()){
            JOptionPane.showMessageDialog(this, "Você não tem permissão para alterar esse usuário!");
            return false;
        }
        try{
            PecaCadastro.editar(this,item);
            return true;
        }
        catch(Exception e) {
            return false;
        } 
    }

    @Override
    protected boolean permissaoRemover() {
        return LoginController.getUsuarioLogado().permissaoAdministrador() || LoginController.getUsuarioLogado().permissaoCapitao();
    }

    @Override
    protected boolean preFiltro(Peca item) {
        if(LoginController.getUsuarioLogado().permissaoAdministrador())
           return true;
        
        return LoginController.getUsuarioLogado().getEquipeId() == item.getEquipeId();
    }
    
}
