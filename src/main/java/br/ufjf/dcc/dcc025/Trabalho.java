/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufjf.dcc.dcc025;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Davi
 */
public class Trabalho {

    public static ArrayList<Equipe> equipes = new ArrayList();
    public static ArrayList<Competidor> competidores = new ArrayList();
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
                System.out.print("Opção: ");
                opcao = input.nextInt();
            } while (opcao < 1 || opcao > 5);


            switch (opcao) {
                case 1 -> {
                    CadastrarEquipe(input);
                }
                case 2 -> {
                    CadastrarRobo(input);
                }
                case 3 -> {
                    CadastrarCompetidor(input);                
                }
                case 4 -> {
                    CadastrarCategoria(input);                
                }
                case 5 -> {
                    System.out.println("Obrigado por usar nosso sistema!");
                }
            }         
        }
    }
    
    public static void CadastrarEquipe(Scanner input){
        int id = equipes.size() + 1;
        System.out.print("Digite o nome da equipe:");
        input.nextLine();
        String nome = input.nextLine();
        System.out.print("Digite a cidade da equipe:");
        input.nextLine();
        String cidade = input.nextLine();
        
        
        Equipe equipe = new Equipe(id, nome, cidade);
        equipes.add(equipe);        
    }
    public static void CadastrarRobo(Scanner input){
        int equipeId = SelecionaEquipe(input); 
        
    }
    public static void CadastrarCompetidor(Scanner input){
        int id = competidores.size()+1;
        
        System.out.println("Digite o nome do competidor:");
        input.nextLine();
        String nome = input.nextLine();
        System.out.println("Digite o documento do competidor:");
        //input.nextLine();
        String documento = input.nextLine();
        System.out.println("Digite a categoria do competidor:");
       // input.nextLine();
        String categoria = input.nextLine();
        System.out.println("Digite a equipe do competidor:");
       // input.nextLine();
        String equipe = input.nextLine();
        
        Competidor competidor = new Competidor(id, nome, documento, equipe, categoria);
        competidores.add(competidor);
    }
    public static void CadastrarCategoria(Scanner input){
        
    }
    
    private static int SelecionaEquipe(Scanner input){
        int id;
        do {            
            System.out.println("Qual equipe deseja selecionar?");
            for(Equipe equipe: equipes){
                System.out.println(String.format("  %d) %s", equipe.id, equipe.nome));
            }
            System.out.print("Opção: ");        
            id = input.nextInt();
        } while (id < 0 || id > equipes.size());        
        
        return id;
    }
    
    
}
