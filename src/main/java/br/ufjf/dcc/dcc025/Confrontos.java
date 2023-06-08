/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025;
import br.ufjf.dcc.dcc025.RinoCup;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Confrontos {
    public static void confrontos() {
        Scanner input = new Scanner(System.in);
        System.out.println("De qual categoria será o confronto?");
        int id = RinoCup.SelecionaCategoria(input);
        
        if(id == 1){
            int min = 0;
            int max = 15;
            int val1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            int val2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        }
        
        else if(id == 2){
            int min = 0;
            int max = 2;
            int val1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            int val2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        }
        else if(id == 3){
            int min = 0;
            int max = 2;
            int val1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            int val2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        }
        else if(id == 4){
            int min = 0;
            int max = 10;
            int val1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            int val2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        }
        else if(id == 5){
            float min = 10;
            float max = 30;
            float val1 = (float)Math.floor(Math.random() * (max - min + 1) + min);
            float val2 = (float)Math.floor(Math.random() * (max - min + 1) + min);
        }
        
        //falta pontuacao pro perseguidor e pro combate q eu n sei como funciona
    }
}
