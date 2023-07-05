package br.ufjf.dcc.dcc025.model;

import br.ufjf.dcc.dcc025.interfaces.IEntidadeRepository;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class Robo implements IEntidadeRepository {

    int id;
    String nome;
    int equipeId;
    Categoria categoria;

    public Robo(String nome, int equipeId, Categoria categoria) {
        this.nome = nome;
        this.equipeId = equipeId;
        this.categoria = categoria;
    }
    
    public Robo(int id, String nome, int equipeId, Categoria categoria) {
        this(nome, equipeId, categoria);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoriaId(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return String.format("%d | %s | %s | %d", id, nome, categoria.getNome(), equipeId);
    }
    
}
