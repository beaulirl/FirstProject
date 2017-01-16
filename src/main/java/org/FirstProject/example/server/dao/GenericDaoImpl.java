package org.FirstProject.example.server.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Admin on 10.12.2016.
 */
@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K > {

    private Class<? extends T> daoType;
    private SessionFactory sessionFactory;

    public GenericDaoImpl() {
        daoType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(T entity) {
        currentSession().save(entity);
    }

    public void update(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        currentSession().delete(entity);
    }

    public T find(K key) {
        return (T) currentSession().get(daoType, key);
    }

    public List<T> findAll(){
        return currentSession().createCriteria(daoType).list();
    }


    public void deleteAll(){
        List<T> ingredients = findAll();
        for (T ingredient : ingredients) {
            delete(ingredient);
        }
    }

}
