package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.exception.EmailException;
import br.ufjf.dcc.dcc025.model.Email;
import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.repository.UsuarioRepository;
import br.ufjf.dcc.dcc025.view.Login;
import javax.swing.JOptionPane;

public class LoginController {
    private static Usuario usuarioLogado;
    public static void Init(){
        UsuarioRepository repository = new UsuarioRepository();
        if(!repository.findAll().isEmpty())
            return;
        
        try{
            repository.save(Usuario.UsuarioAdmin(1, "Gabriel", new Email("gabriel@gmail.com"), "Senha123"));
            repository.save(Usuario.UsuarioAdmin(2, "Davi", new Email("davi@gmail.com"), "Senha123"));
            repository.save(Usuario.UsuarioAdmin(3, "Daniel", new Email("daniel@gmail.com"), "Senha123"));
            repository.save(Usuario.UsuarioAdmin(4, "Gleiph", new Email("gleiph@gmail.com"), "Senha123"));
        } 
        catch(EmailException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível iniciar o sistema!");
            System.exit(2);
        }                
    }
    public static void Logar(){
        Login login = new Login();
        usuarioLogado = login.Logar();
        
        if(usuarioLogado == null)
            System.exit(0);
    }
    
    public static Usuario getUsuarioLogado(){
        return usuarioLogado;
    }
}
