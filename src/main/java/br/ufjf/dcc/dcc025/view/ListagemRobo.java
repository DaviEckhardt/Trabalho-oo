package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.controller.LoginController;
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
        return false;
    }

    @Override
    protected boolean Editar() {
        return false;
    }
    
    @Override
    protected boolean PermissaoRemover() {
        return LoginController.getUsuarioLogado().permissaoAdministrador() || LoginController.getUsuarioLogado().permissaoCapitao();
    }
} 
