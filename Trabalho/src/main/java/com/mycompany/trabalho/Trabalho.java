/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho;

import java.util.Scanner;

/**
 *
 * @author Davi
 */
public class Trabalho {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de competições!");
        
        int opcao = 0;
        while (opcao != 5) {
            do {
                System.out.println("Menu principal:");
                System.out.println(" 1) Cadastrar Equipe");
                System.out.println(" 2) Cadastrar Robô");
                System.out.println(" 3) Cadastrar Competidor");
                System.out.println(" 4) Cadastrar Categoria");            
                System.out.println(" 5) Sair");
                System.out.println("Opção: ");
                opcao = input.nextInt();
            } while (opcao < 1 || opcao > 4);


            switch (opcao) {
                case 1 -> {
                    CadastrarEquipe();
                }
                case 2 -> {
                    CadastrarRobo();
                }
                case 3 -> {
                    CadastrarCompetidor();                
                }
                case 4 -> {
                    CadastrarCategoria();                
                }
                case 5 -> {
                    System.out.println("Obrigado por usar nosso sistema!");
                }
            }         
        }
    }
    
    public static void CadastrarEquipe(){
        
    }
    public static void CadastrarRobo(){
        
    }
    public static void CadastrarCompetidor(){
        
    }
    public static void CadastrarCategoria(){
        
    }
    
}
