package br.ufjf.dcc.dcc025.repository;

import br.ufjf.dcc.dcc025.model.Peca;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class PecaRepository extends Repository<Peca> {

    public PecaRepository() {
        super("peca");
    }

    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Peca>>(){}.getType();
    }    
}
