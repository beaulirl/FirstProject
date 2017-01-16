package org.FirstProject.example.server.dao;

import org.FirstProject.example.server.model.Ingredient;

/**
 * Created by Admin on 13.12.2016.
 */
public interface IngredientDao extends GenericDao<Ingredient, Integer> {
    boolean removeIngredient(Ingredient ingredient);
}
