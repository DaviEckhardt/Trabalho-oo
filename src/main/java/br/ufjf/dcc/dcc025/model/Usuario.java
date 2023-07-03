package br.ufjf.dcc.dcc025.model;

public class Usuario implements IEntidadeRepository {
    int id;
    String nome;
    Email email;
    String senha;    
    TipoUsuario tipo;
    Categoria categoria;
    int equipeId;
    
    public Usuario(int id, String nome, Email email, String senha, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(int id, String nome, Email email, String senha, TipoUsuario tipo, Categoria categoria, int equipeId) {
        this(id, nome, email, senha, tipo);
        this.categoria = categoria;
        this.equipeId = equipeId;
    }
    
    public static Usuario UsuarioAdmin(int id, String nome, Email login, String senha){
        return new Usuario(id, nome, login, senha, TipoUsuario.Administrador, Categoria.Sistema, 0);
    }
    public static Usuario UsuarioCapitao(int id, String nome, Email login, String senha, int equipeId){
        return new Usuario(id, nome, login, senha, TipoUsuario.Capitao, Categoria.Gerencia, equipeId);
    }
    public static Usuario UsuarioCompetidor(int id, String nome, Email login, String senha, int equipeId, Categoria categoria){
        return new Usuario(id, nome, login, senha, TipoUsuario.Competidor, categoria, equipeId);
    }

    @Override
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEmail();
    }    
    public String getLogin() {
        return email.getLogin();
    }
    
    public String getSenha() {
        return senha;
    }
   
    public TipoUsuario getTipo() {
        return tipo;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public int getEquipeId() {
        return equipeId;
    }
    
    public boolean permissaoAdministrador(){
        return tipo == TipoUsuario.Administrador;
    } 
    public boolean permissaoCapitao(){
        return tipo == TipoUsuario.Capitao;
    } 

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(Email email) {
        this.email = email;
    }    
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
       
    public void getCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }
    
    @Override
    public String toString(){
        return String.format("%d | %s | %s | %s | %s", id, nome, email.getEmail(), categoria.getNome(), tipo.name());
    }
}

