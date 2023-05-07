/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho;

/**
 *
 * @author Davi
 */
public class Trabalho {

    public static void main(String[] args) {
        Equipe equipe = new Equipe(20354, "Rinobot", "Juiz de Fora");
        Robo robo = new Robo(201, "Nego ney", 20354, 23);
        Competidor competidor = new Competidor(2056, "João", "103.520.457-45", "Rinobot", "Seguidor de linha");
    
        System.out.println(equipe.getNome());
    
    }
}
