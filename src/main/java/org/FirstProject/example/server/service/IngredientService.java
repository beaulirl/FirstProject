package org.FirstProject.example.server.service;

import org.FirstProject.example.server.model.Ingredient;

/**
 * Created by Admin on 14.12.2016.
 */
public interface IngredientService extends GenericService<Ingredient, Integer> {
    boolean removeIngredient(Ingredient ingredient);
}
