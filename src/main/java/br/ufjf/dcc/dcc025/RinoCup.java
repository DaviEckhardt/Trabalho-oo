/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
package br.ufjf.dcc.dcc025;
import br.ufjf.dcc.dcc025.controller.LoginController;

import br.ufjf.dcc.dcc025.view.Menu;
import javax.swing.JFrame;

/**
 *
 * @author Davi
 */
public class RinoCup {

  
    public static void main(String[] args) {
        LoginController.Init();
        LoginController.Logar();
        Menu janela = new Menu();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
