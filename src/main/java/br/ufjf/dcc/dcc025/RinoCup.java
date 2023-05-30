/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufjf.dcc.dcc025;

import br.ufjf.dcc.dcc025.controller.EquipeController;
import br.ufjf.dcc.dcc025.model.Competidor;
import br.ufjf.dcc.dcc025.model.Robo;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.model.Categoria;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Davi
 */
public class RinoCup {

    public static ArrayList<Equipe> equipes = new ArrayList();
    public static ArrayList<Competidor> competidores = new ArrayList();
    public static ArrayList<Robo> robos = new ArrayList();
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de competições!");
        
        int opcao = 0;
        while (opcao != 4) {
            do {
                System.out.println("Menu principal:");
                System.out.println(" 1) Cadastrar Equipe");
                System.out.println(" 2) Cadastrar Robô");
                System.out.println(" 3) Cadastrar Competidor");        
                System.out.println(" 4) Sair");
                System.out.print("Opção: ");
                opcao = input.nextInt();
            } while (opcao < 1 || opcao > 4);


            switch (opcao) {
                case 1 -> {
                    CadastrarEquipe();
                }
                case 2 -> {
                    CadastrarRobo(input);
                }
                case 3 -> {
                    CadastrarCompetidor(input);                
                }
                case 4 -> {
                    System.out.println("Obrigado por usar nosso sistema!");
                }
            }         
        }
    }
    
    public static void CadastrarEquipe(){
        EquipeController controller = new EquipeController();
        controller.CadastrarEquipe();
    }
    public static void CadastrarRobo(Scanner input){
        int id = robos.size() + 1;
        System.out.print("Digite o nome do robô: ");
        String nome = input.nextLine();
        int equipeId = SelecionaEquipe(); 
        int categoriaId = SelecionaCategoria(input);
        
        robos.add(new Robo(id, nome, equipeId, categoriaId));
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
    
    private static int SelecionaEquipe(){
        EquipeController controller = new EquipeController();
        return controller.SelecionaEquipe();
    }
    
    private static int SelecionaCategoria(Scanner input){
        int id;
        do { 
            System.out.println("Qual categoria deseja selecionar?");
            for (Categoria categoria : Categoria.values()) {
                System.out.println("  " + categoria);
            }
            System.out.print("Opção: ");
            id = input.nextInt();        
        } while (id < 0 || id > Categoria.values().length);        
        
        return id;        
    }
}
