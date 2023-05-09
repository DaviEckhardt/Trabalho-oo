/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025;

/**
 *
 * @author danie
 */

public enum Categoria {
    VSS(1, "VSS"),
    MiniSumo(2, "Mini Sumo"),
    SumoLego(3,"Sumo Lego"),
    SPL(4, "SPL"),
    Seguidor(5, "Seguidor de Linha"),
    Perseguidor(6, "Perseguidor de Linha"),
    Combate(7, "Combate");
    
    private final int id;
    private final String nome;

    private Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public int getId(){
        return id;
    }
    
    @Override
    public String toString(){
        return String.format("%d) %s", id, nome);
    }    
}