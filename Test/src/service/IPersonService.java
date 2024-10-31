package service;

import java.util.List;

public interface IPersonService<T> {
    List<T> getAll();

    List<T> getAllSortById();

    boolean add(T s);

    List<T> findByName(String name);
}
