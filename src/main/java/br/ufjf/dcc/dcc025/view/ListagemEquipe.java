package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.interfaces.IPesquisa;
import br.ufjf.dcc.dcc025.model.ModoTela;
import br.ufjf.dcc.dcc025.repository.EquipeRepository;
import br.ufjf.dcc.dcc025.repository.IRepository;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class ListagemEquipe extends ListagemBase<Equipe> {

    private final EquipeRepository repository;
    
    public ListagemEquipe(ModoTela modo){
        this(modo, null);
    }
    
    public ListagemEquipe(ModoTela modo, IPesquisa tela){
        super(modo, tela);
        repository = new EquipeRepository();
    }
    
    public static void selecionar(IPesquisa tela){
        ListagemEquipe listagem = new ListagemEquipe(ModoTela.Pesquisa, tela);
        listagem.mostrar();
    }
    
    public static void exibir(){
        ListagemEquipe listagem = new ListagemEquipe(ModoTela.Listagem);
        listagem.mostrar();
    }
    @Override
    protected IRepository<Equipe> getRepository() {
        return repository;
    }

    @Override
    protected boolean cadastrar() {
        try{
            EquipeCadastro.cadastrar(this);
            return true;
        }
        catch(Exception e) {
            return false;
        }  
    }

    @Override
    protected boolean editar(Equipe item) {
        try{
            EquipeCadastro.editar(this, item);
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
    protected boolean preFiltro(Equipe item) {
        if(LoginController.getUsuarioLogado().permissaoAdministrador())
           return true;
        
        return LoginController.getUsuarioLogado().getEquipeId() == item.getId();
    }
    
}