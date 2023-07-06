package br.ufjf.dcc.dcc025.repository;


import br.ufjf.dcc.dcc025.interfaces.IEntidadeRepository;
import br.ufjf.dcc.dcc025.utils.Arquivo;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public abstract class Repository<T extends IEntidadeRepository> implements IRepository<T> {
    private String PATH = DIRECTORY+ File.separator;
    protected abstract Type getTipoLista();
    
    public Repository(String entidade) {
        PATH += entidade + ".json";
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
    }    
    
    protected int lastId(){
        List<T> list = findAll();
        if(list.isEmpty())
            return 1;
        
        return list.get(list.size() - 1).getId() + 1;
    }
    protected T genId(T item){
        if(item.getId() <= 0)
            item.setId(lastId());
        
        return item;
    }
    @Override
    public void save(List<T> itens) {        
        for(int i = 0; i < itens.size(); i++)
            itens.set(i, genId(itens.get(i)));
        
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
        
        if(item.getId() > 0){       
            boolean achou = false;
            for(T savedItem : list){
               if(savedItem.getId() == item.getId()){
                   list.set(list.indexOf(savedItem), item);
                   achou = true;
               }                   
            }
            if (!achou)
                list.add(item);
        }
        else{            
            item = genId(item);        
            list.add(item);
        }        
        save(list);        
    }
    
    @Override
    public void remove(T item) {
        List<T> list = findAll();
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == item.getId()){
                list.remove(i);
                break;
            }
        }        
        save(list);
    }
    
    public T getById(int id){
        List<T> list = findAll();
        
        for(T item: list){
            if(item.getId() == id)
                return item;
        }
        
        return null;
    }

}
