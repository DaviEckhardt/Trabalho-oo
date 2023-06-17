/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Competidor;
import java.util.List;

/**
 *
 * @author ice
 */
public class CompetidorRepository extends Repository<Competidor> {
    
    public CompetidorRepository() {
        super("competidor");
    }
    
    @Override
    public void remove(Competidor item) {
        List<Competidor> list = findAll();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == item.getId()){
                list.remove(i);
                break;
            }
        }        
        save(list);
    }
}
