package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.interfaces.IRepository;
import br.ufjf.dcc.dcc025.repository.RoboRepository;
import javax.swing.JOptionPane;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
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
    
    public static void selecionar(IPesquisa tela){
        ListagemRobo listagem = new ListagemRobo(ModoTela.Pesquisa, tela);
        listagem.mostrar();
    }
    
    public static void exibir(){
        ListagemRobo listagem = new ListagemRobo(ModoTela.Listagem);
        listagem.mostrar();
    }
    
    @Override
    protected IRepository<Robo> getRepository() {
        return repository;
    }

    @Override
    protected boolean cadastrar() {
        try{
            RoboCadastro.cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }  
    }

    @Override
    protected boolean editar(Robo item) {
        Usuario usuarioLogado = LoginController.getUsuarioLogado();
        if(!usuarioLogado.permissaoCapitao() && !usuarioLogado.permissaoAdministrador()){
            JOptionPane.showMessageDialog(this, "Você não tem permissão para alterar esse usuário!");
            return false;
        }
        try{
            RoboCadastro.editar(this,item);
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
    protected boolean preFiltro(Robo item) {
        if(LoginController.getUsuarioLogado().permissaoAdministrador())
           return true;
        
        return LoginController.getUsuarioLogado().getEquipeId() == item.getEquipeId();
    }
} 
