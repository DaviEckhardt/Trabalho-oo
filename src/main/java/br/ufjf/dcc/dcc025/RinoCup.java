/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
package br.ufjf.dcc.dcc025;

import br.ufjf.dcc.dcc025.controller.EquipeController;
import br.ufjf.dcc.dcc025.controller.LoginController;
import br.ufjf.dcc.dcc025.view.ListagemBase;
import br.ufjf.dcc.dcc025.view.ListagemEquipe;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.model.Categoria;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import br.ufjf.dcc.dcc025.model.Email;
import br.ufjf.dcc.dcc025.exception.EmailException;

/**
 *
 * @author Davi
 */
public class RinoCup {

  
    public static void main(String[] args) {
        LoginController.Logar();
        System.out.println("TA QQQ");
        Equipe equipe = ListagemEquipe.Selecionar();
        System.out.println(equipe);
        
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
                    input.nextLine();
                    CadastrarCompetidor(input);                
                }
                case 4 -> {
                    System.out.println("Obrigado por usar nosso sistema!");
                }
            }         
        }
        Confrontos.confrontos();
    }
    
    public static void CadastrarEquipe(){
        EquipeController controller = new EquipeController();
        controller.CadastrarEquipe();
    }
    public static void CadastrarRobo(Scanner input){
//        int id = robos.size() + 1;
        System.out.print("Digite o nome do robô: ");
        input.nextLine();
        String nome = input.nextLine();
        int equipeId = SelecionaEquipe(); 
        int categoriaId = SelecionaCategoria(input);
        
//        robos.add(new Robo(id, nome, equipeId, categoriaId));
    }
    public static int CadastrarCompetidor(Scanner input){
//        int id = competidores.size()+1;
        

        System.out.println("Digite o nome do competidor:");
        String nome = input.nextLine();
        System.out.println("Digite o documento do competidor:");
        String documento = input.nextLine();
        System.out.println("Digite a categoria do competidor:");
        String categoria = input.nextLine();
        System.out.println("Digite a equipe do competidor:");
        String equipe = input.nextLine();
        System.out.println("Digite o e-mail do competidor:");
        String aux = input.nextLine();
        Email email;
        try{
          email = new Email(aux);
        }
        catch(EmailException e){
            System.out.println("O email é inválido!");
            //return CadastrarCompetidor(input);
        }
        
        
        //Competidor competidor = new Competidor(1, nome, documento, equipe, categoria, email == null ?);
        //competidores.add(competidor);
        
        return 1;
    }  
    
    public static int SelEquipe(){
        return SelecionaEquipe();
    }
    private static int SelecionaEquipe(){
        EquipeController controller = new EquipeController();
        return controller.SelecionaEquipe();
    }
    
    public static int SelecionaCategoria(Scanner input){
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
