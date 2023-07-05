package br.ufjf.dcc.dcc025.view;

import br.ufjf.dcc.dcc025.model.Robo;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class JRoboField extends JTextField {
    private Robo robo;
    public JRoboField(){
        super();
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                adjustTextFieldSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                adjustTextFieldSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                adjustTextFieldSize();
            }            
        });
    }
    
    private void adjustTextFieldSize() {
        String text = this.getText();
        int columns = Math.max(text.length(), 10); // Define um mínimo de 10 colunas
        this.setColumns(columns);
    }
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
