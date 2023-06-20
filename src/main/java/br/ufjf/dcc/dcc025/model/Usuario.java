package br.ufjf.dcc.dcc025.model;

public class Usuario {
    int id;
    String nome;
    String login;
    String senha;
    TipoUsuario tipo;

    public Usuario(int id, String nome, String login, String senha, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public static Usuario UsuarioAdmin(int id, String nome, String login, String senha){
        return new Usuario(id, nome, login, senha, TipoUsuario.Administrador);
    }
    public static Usuario UsuarioCapitao(int id, String nome, String login, String senha){
        return new Usuario(id, nome, login, senha, TipoUsuario.Capitao);
    }
    public static Usuario UsuarioCompetidor(int id, String nome, String login, String senha){
        return new Usuario(id, nome, login, senha, TipoUsuario.Competidor);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
   
    public TipoUsuario getTipo() {
        return tipo;
    }

    public boolean permissaoAdministrador(){
        return tipo == TipoUsuario.Administrador;
    } 
    public boolean permissaoCapitao(){
        return tipo == TipoUsuario.Capitao;
    } 
}

