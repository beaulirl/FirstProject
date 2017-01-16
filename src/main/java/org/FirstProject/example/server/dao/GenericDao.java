package org.FirstProject.example.server.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 09.12.2016.
 */
public interface GenericDao<T, K> {
    public void add(T entity);

    public void update(T entity);

    public T find(K key);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
