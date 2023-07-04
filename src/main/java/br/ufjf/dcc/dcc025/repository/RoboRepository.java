/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Categoria;
import br.ufjf.dcc.dcc025.model.Robo;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    protected Type getTipoLista() {
        return new TypeToken<List<Robo>>(){}.getType();
    }

    public boolean roboExiste(String nome, Categoria categoria) {
        List<Robo> list = findAll();
        for(Robo robo: list){
            if(robo.getNome().equals(nome) && robo.getCategoria().equals(categoria))
                return true;
        }
        
        return false;
    }
    
    public List<Robo> getByCategoria(Categoria categoria){
        List<Robo> list = findAll();
        List<Robo> filtrada = new ArrayList<>();
        for(Robo robo: list){
            if(robo.getCategoria().equals(categoria))
                filtrada.add(robo);
        }
        return filtrada;
    }
}
