/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.Robo;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class JRoboField extends JTextField {
    private Robo robo;
    public void setRobo(Robo robo){
        this.robo = robo;
        
        if(robo == null)
            this.setText("W.O");
        else
            this.setText(robo.getNome());
    }
    
    public Robo getRobo(){
        return robo;
    }
}
