/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Usuario;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author Gabriel
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
}
