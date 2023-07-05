package br.ufjf.dcc.dcc025.model;

import br.ufjf.dcc.dcc025.interfaces.IEntidadeRepository;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/
public class Peca implements IEntidadeRepository {
    int id;
    String nome;
    int valor;
    int quantidade;
    int roboId; 
    int equipeId;
    
    public Peca(int id, String nome, int valor, int quantidade, int roboId, int equipeId) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.roboId = roboId;
        this.equipeId = equipeId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getRoboId() {
        return roboId;
    }

    public void setRoboId(int roboId) {
        this.roboId = roboId;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | R$%d | Qtd: %d | Robô: %d", id, nome, valor, quantidade, roboId);
    }
    
    
}
