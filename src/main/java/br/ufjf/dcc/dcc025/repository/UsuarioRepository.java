/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Usuario;
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
            Usuario item = list.get(i);
            if(item.getLogin().equals(login) && item.getSenha().equals(senha))
                return item;
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
    
}
