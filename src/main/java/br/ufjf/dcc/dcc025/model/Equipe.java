package br.ufjf.dcc.dcc025.model;

import br.ufjf.dcc.dcc025.interfaces.IEntidadeRepository;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class Equipe implements IEntidadeRepository {
    int id;
    String nome;
    String cidade;

    public Equipe(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }
    
    public Equipe(int id, String nome, String cidade) {
        this(nome, cidade);
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public String toString(){
        return String.format("%d | %s | %s", this.id, this.nome, this.cidade);
    }
    
            
}
