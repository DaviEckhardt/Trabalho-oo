/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.model;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

/**
 *
 * @author daniel
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
}
