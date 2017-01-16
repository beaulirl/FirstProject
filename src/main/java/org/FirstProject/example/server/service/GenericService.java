package org.FirstProject.example.server.service;

import java.util.List;

/**
 * Created by Admin on 10.12.2016.
 */
public interface GenericService<T, K> {
    public void add(T entity);

    public void update(T entity);

    public T find(K id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
