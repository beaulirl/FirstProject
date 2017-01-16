package org.FirstProject.example.server.dao;

import org.FirstProject.example.server.model.Dish;

/**
 * Created by Admin on 13.12.2016.
 */
public interface DishDao extends GenericDao<Dish, Integer> {
    boolean removeDish(Dish dish);
}
