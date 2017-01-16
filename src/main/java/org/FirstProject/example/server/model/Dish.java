package org.FirstProject.example.server.model;
import javax.persistence.*;
import org.FirstProject.example.server.model.Ingredient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 09.12.2016.
 */
@Entity
@Table(name="model.Dish")

public class Dish {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="recept")
    private String recept;

    @Column(name="price")
    private Integer price;

    @Column(name="user")
    private String user;

    @OneToMany
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (!id.equals(dish.id)) return false;
        if (!name.equals(dish.name)) return false;
        if (!type.equals(dish.type)) return false;
        if (!recept.equals(dish.recept)) return false;
        if (!price.equals(dish.price)) return false;
        if (!user.equals(dish.user)) return false;
        return ingredients.equals(dish.ingredients);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + recept.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + ingredients.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", recept='" + recept + '\'' +
                ", price=" + price +
                ", user='" + user + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
