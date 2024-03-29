package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Equipe;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class EquipeRepository extends Repository<Equipe> {
    public EquipeRepository(){
        super("equipe");             
    }   
    
    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Equipe>>(){}.getType();
    }
    
    public boolean equipeExiste(String nome, String cidade){
        List<Equipe> list = findAll();
        for(Equipe equipe: list){
            if(equipe.getNome().equals(nome) && equipe.getCidade().equals(cidade))
                return true;
        }
        
        return false;
    }
}
