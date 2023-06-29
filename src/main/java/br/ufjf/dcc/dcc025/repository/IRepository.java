/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufjf.dcc.dcc025.repository;
import java.util.List;
import br.ufjf.dcc.dcc025.model.IEntidadeRepository;
/**
 *
 * @author Gabriel
 * @param <T>
 */
public interface IRepository<T extends IEntidadeRepository> {
    String DIRECTORY = "data";
    public void save(T item);
    public void save(List<T> itens);
    public List<T> findAll();
    public void remove(T item);
}
