/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;


import br.ufjf.dcc.dcc025.utils.Arquivo;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
/**
 *
 * @author Gabriel
 * @param <T>
 */
public abstract class Repository<T> implements IRepository<T> {
    private String PATH = DIRECTORY+ File.separator;
    protected abstract Type getTipoLista();
    public Repository(String entidade) {
        PATH += entidade + ".json";
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
    }
    
    
    @Override
    public void save(List<T> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);
        Arquivo.save(PATH, json);
    }

    @Override
    public List<T> findAll() {
        Gson gson = new Gson();
        String json = Arquivo.read(PATH);

        List<T> itens = new ArrayList<>();
        if(!json.trim().equals("")) {                       
            Type tipoLista = getTipoLista();
            itens = gson.fromJson(json, tipoLista);

            if (itens == null)
                itens = new ArrayList<>();
        }
        return itens;
    }

    @Override
    public void save(T item) {
        List<T> list = findAll();
        list.add(item);
        save(list);
    }
    


}
