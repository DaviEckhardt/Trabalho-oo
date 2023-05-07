/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho;
import java.util.*;
/**
 *
 * @author Davi
 * @param <T>
 */
public class Competicao<T> {
    private ArrayList<T> lista_robos;
    
    public Competicao(ArrayList<T> lista_robos) {
        this.lista_robos = lista_robos;
    }
    public ArrayList<T> getLista_robos() {
        return lista_robos;
    }

    public void setLista_robos(ArrayList<T> lista_robos) {
        this.lista_robos = lista_robos;
    }

    
    
    
}
