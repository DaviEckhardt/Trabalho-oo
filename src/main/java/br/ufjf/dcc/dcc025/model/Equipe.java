package br.ufjf.dcc.dcc025.model;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class Equipe {
    int id;
    int capitaoId;
    String nome;
    String cidade;

    public Equipe(int id, String nome, String cidade, int capitaoId) {
        this.id = id;
        this.capitaoId = capitaoId;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getCapitaoId() {
        return capitaoId;
    }

    public void setCapitaoId(int capitaoId) {
        this.capitaoId = capitaoId;
    }

    public int getId() {
        return id;
    }

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
    
            
}
