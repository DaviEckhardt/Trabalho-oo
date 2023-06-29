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
    }   
    
    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Equipe>>(){}.getType();
    }
}
