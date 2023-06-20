package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.model.Usuario;
import br.ufjf.dcc.dcc025.view.Login;

public class LoginController {
    public static Usuario usuarioLogado;
    
    public static void Logar(){
        Login login = new Login();
        usuarioLogado = login.Logar();
    }
}
