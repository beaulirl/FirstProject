package org.FirstProject.example.server.service;

import org.FirstProject.example.server.model.Dish;

/**
 * Created by Admin on 14.12.2016.
 */
public class DishServiceImpl extends GenericServiceImpl<Dish, Integer> implements DishService {

    public boolean removeDish(Dish dish) {
       genericDao.delete(dish);
        return true;
    }
}
