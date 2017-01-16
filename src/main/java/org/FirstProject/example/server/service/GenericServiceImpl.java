package org.FirstProject.example.server.service;

import org.FirstProject.example.server.dao.GenericDao;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by Admin on 10.12.2016.
 */
@Service
public abstract class GenericServiceImpl<T, K> implements GenericService<T, K> {

    protected GenericDao<T, K> genericDao;

    public GenericServiceImpl(GenericDao<T, K> genericDao) {
        this.genericDao=genericDao;
    }

    public GenericServiceImpl() {
    }


    @Transactional
    public void add(T entity) {
        genericDao.add(entity);
    }


    @Transactional
    public List<T> findAll() {
        return genericDao.findAll();
    }


    @Transactional
    public T find(K key) {
        return genericDao.find(key);
    }


    @Transactional
    public void update(T entity) {
        genericDao.update(entity);
    }

    @Transactional
    public void delete(T entity) {
        genericDao.delete(entity);
    }

    @Transactional
    public void deleteAll() {
        genericDao.deleteAll();
    }


}
