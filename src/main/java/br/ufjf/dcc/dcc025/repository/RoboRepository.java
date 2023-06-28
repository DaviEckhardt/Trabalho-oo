/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Robo;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author ice
 */
public class RoboRepository extends Repository<Robo>{    
    public RoboRepository() {
        super("robo");
    }
    
    @Override
    public void remove(Robo item) {
        List<Robo> list = findAll();
        
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
        return new TypeToken<List<Robo>>(){}.getType();
    }
}
