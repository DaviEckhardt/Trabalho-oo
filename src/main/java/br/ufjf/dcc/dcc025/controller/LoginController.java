package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.exception.EmailException;
import br.ufjf.dcc.dcc025.model.Email;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import br.ufjf.dcc.dcc025.view.Login;
import javax.swing.JOptionPane;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class LoginController {
    private static Usuario usuarioLogado;
    public static void iniciar(){
        UsuarioRepository repository = new UsuarioRepository();
        if(!repository.findAll().isEmpty())
            return;
        
        try{
            repository.save(Usuario.usuarioAdmin(1, "Gabriel", new Email("gabriel@gmail.com"), "Senha123"));
            repository.save(Usuario.usuarioAdmin(2, "Davi", new Email("davi@gmail.com"), "Senha123"));
            repository.save(Usuario.usuarioAdmin(3,"Daniel", new Email("daniel@gmail.com"), "Senha123"));
            repository.save(Usuario.usuarioAdmin(4, "Gleiph", new Email("gleiph@gmail.com"), "Senha123"));
        } 
        catch(EmailException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível iniciar o sistema!");
            System.exit(2);
        }                
    }
    public static void logar(){
        Login login = new Login();
        usuarioLogado = login.logar();
        
        if(usuarioLogado == null)
            System.exit(0);
    }
    
    public static Usuario getUsuarioLogado(){
        return usuarioLogado;
    }
}
