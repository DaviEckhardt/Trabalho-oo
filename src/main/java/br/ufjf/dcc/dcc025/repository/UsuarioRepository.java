package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Usuario;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class UsuarioRepository extends Repository<Usuario>  {

    public UsuarioRepository() {
        super("usuario");  
    }

    public Usuario obterPorLoginSenha(String login, String senha){
        if(login == null || senha == null)
            return null;
        List<Usuario> list = findAll();

        for (int i = 0; i < list.size(); i++) {
            Usuario usuario = list.get(i);
            
            if((usuario.getLogin().equalsIgnoreCase(login) || usuario.getEmail().equalsIgnoreCase(login)) && usuario.getSenha().equals(senha))
                return usuario;                
        }       
        
        return null;
    }
    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Usuario>>(){}.getType();
    }

    public boolean emailExiste(String email) {
        List<Usuario> list = findAll();
        for(Usuario usuario: list){
            if(usuario.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public Usuario getCapitao(int equipeId) {
        List<Usuario> list = findAll();
        for(Usuario usuario: list){
            if(usuario.permissaoCapitao() && usuario.getEquipeId() == equipeId)
                return usuario;
        }
        return null;
    }
}
