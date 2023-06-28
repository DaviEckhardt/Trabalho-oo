package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Equipe;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author ice
 */
public class EquipeRepository extends Repository<Equipe> {
    public EquipeRepository(){
        super("equipe");     
        
        save(new Equipe(1, "RINO", "JF", 1));
    }
    
    @Override
    public void remove(Equipe item) {
        List<Equipe> list = findAll();
        
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
        return new TypeToken<List<Equipe>>(){}.getType();
    }

}
