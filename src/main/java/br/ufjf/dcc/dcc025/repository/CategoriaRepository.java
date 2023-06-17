/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Categoria;
import java.util.List;

/**
 *
 * @author ice
 */
public class CategoriaRepository extends Repository<Categoria> {
    
    public CategoriaRepository() {
        super("categoria");
    }
    
        @Override
    public void remove(Categoria item) {
        List<Categoria> list = findAll();
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == item.getId()){
                list.remove(i);
                break;
            }
        }        
        save(list);
    }
}
