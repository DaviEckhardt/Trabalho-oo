/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.TipoUsuario;
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
        save(new Usuario(1, "gabriel", "gabriel", "123", TipoUsuario.Administrador));
    }

    public Usuario obterPorLoginSenha(String login, String senha){
        if(login == null || senha == null)
            return null;
        
        List<Usuario> list = findAll();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getLogin().equals(login) && list.get(i).getSenha().equals(senha))
                return list.get(i);
        }       
        
        return null;
    }
    @Override
    public void remove(Usuario item) {
        List<Usuario> list = findAll();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == item.getId()){
                list.remove(i);
                break;
            }
        }        
        save(list);
    }

    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Usuario>>(){}.getType();
    }
    
}
