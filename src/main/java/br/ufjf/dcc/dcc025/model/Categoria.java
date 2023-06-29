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
    Sistema("Sistema"),
    VSS("VSS"),
    MiniSumo("Mini Sumo"),
    SumoLego("Sumo Lego"),
    SPL("SPL"),
    Seguidor("Seguidor de Linha"),
    Perseguidor("Perseguidor de Linha"),
    Combate("Combate"),
    Gerencia("Gerência");
    
    private final String nome;

    private Categoria(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }    
    @Override
    public String toString(){
        return nome;
    }    
}
