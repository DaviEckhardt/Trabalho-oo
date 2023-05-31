/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.RinoCup;
import br.ufjf.dcc.dcc025.model.Equipe;
import br.ufjf.dcc.dcc025.repository.Repository;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class EquipeController {
    Repository<Equipe> equipes;

    public EquipeController() {
        equipes = new Repository<>();
    }        
        
    
    public void CadastrarEquipe(){
        Scanner input = new Scanner(System.in);
        int id = equipes.findAll().size()+ 1;
        int capitaoId;
        
        System.out.print("Digite o nome da equipe: ");
        String nome = input.nextLine();
        System.out.print("Digite a cidade da equipe: ");
        String cidade = input.nextLine();
        System.out.println("Quem é o capitão da equipe?");
        capitaoId = RinoCup.CadastrarCompetidor(input);
        Equipe equipe = new Equipe(id, nome, cidade, capitaoId);
        equipes.save(equipe);        
    }
    
    public int SelecionaEquipe(){
        Scanner input = new Scanner(System.in);
        int id;
        do {            
            System.out.println("Qual equipe deseja selecionar?");
            for(Equipe equipe: equipes.findAll()){
                System.out.println(String.format("  %d) %s", equipe.getId(), equipe.getNome()));
            }
            System.out.println("  0) Cadastrar nova");
            System.out.print("Opção: ");        
            id = input.nextInt();
            
            if(id == 0)
                CadastrarEquipe();
            
        } while (id <= 0 || id > equipes.findAll().size());        
        
        return id;
    }
}
