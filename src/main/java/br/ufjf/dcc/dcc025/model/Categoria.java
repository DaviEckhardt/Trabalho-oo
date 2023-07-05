package br.ufjf.dcc.dcc025.model;

import java.util.ArrayList;
import java.util.List;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public enum Categoria {
    Sistema("Sistema", false),
    VSSS("VSSS", true),
    MiniSumo("Mini Sumo", true),
    SumoLego("Sumo Lego", true),
    SPL("SPL", true),
    Seguidor("Seguidor de Linha", true),
    Perseguidor("Perseguidor de Linha", true),
    Combate("Combate", true),
    Gerencia("Gerência", false);
    
    private final String nome;
    private final boolean temDisputa;

    private Categoria(String nome, boolean temDisputa) {
        this.nome = nome;
        this.temDisputa = temDisputa;
    }
    public String getNome() {
        return nome;
    }    
    public boolean getTemDisputa() {
        return temDisputa;
    }
    @Override
    public String toString(){
        return nome;
    }    
    
    public static Categoria[] getCategoriasDisputa(){
        List<Categoria> categorias = new ArrayList<>();
        for(Categoria categoria: values()){
            if(categoria.temDisputa){
                categorias.add(categoria);
            }
        }          
        return categorias.toArray(Categoria[]::new);
    }
}
