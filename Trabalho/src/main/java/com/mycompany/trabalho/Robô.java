/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho;

/**
 *
 * @author Davi
 */
public class Robô {
    String id;
    String nome;
    String equipe_id;
    String Categoria_id;

    public Robô(String id, String nome, String equipe_id, String Categoria_id) {
        this.id = id;
        this.nome = nome;
        this.equipe_id = equipe_id;
        this.Categoria_id = Categoria_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(String equipe_id) {
        this.equipe_id = equipe_id;
    }

    public String getCategoria_id() {
        return Categoria_id;
    }

    public void setCategoria_id(String Categoria_id) {
        this.Categoria_id = Categoria_id;
    }
    
    
}
