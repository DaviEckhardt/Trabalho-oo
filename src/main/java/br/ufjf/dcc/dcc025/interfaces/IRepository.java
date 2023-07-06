package br.ufjf.dcc.dcc025.interfaces;
import java.util.List;
import br.ufjf.dcc.dcc025.interfaces.IEntidadeRepository;
/**
    Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
 * @param <T>
 */
public interface IRepository<T extends IEntidadeRepository> {
    String DIRECTORY = "data";
    public void save(T item);
    public void save(List<T> itens);
    public List<T> findAll();
    public void remove(T item);
}
