package br.ufjf.dcc.dcc025.controller;

import br.ufjf.dcc.dcc025.model.TipoUsuario;
import br.ufjf.dcc.dcc025.model.Usuario;

public class LoginController {
    public static Usuario usuarioLogado;

    public boolean permissaoAdministrador(){
        return usuarioLogado.getTipo() == TipoUsuario.Administrador;
    } 
    public boolean permissaoCapitao(){
        return usuarioLogado.getTipo() == TipoUsuario.Capitao;
    } 
}
