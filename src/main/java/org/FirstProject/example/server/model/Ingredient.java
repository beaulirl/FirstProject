package org.FirstProject.example.server.model;

import javax.persistence.*;

/**
 * Created by Admin on 09.12.2016.
 */
@Entity
@Table(name="model.Ingredient")
public class Ingredient {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="fats")
    private Integer fats;

    @Column(name="price")
    private Integer price;

    @Column(name="proteins")
    private Integer proteins;

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

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fats=" + fats +
                ", price=" + price +
                ", proteins=" + proteins +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (fats != that.fats) return false;
        if (price != that.price) return false;
        if (proteins != that.proteins) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + fats;
        result = 31 * result + price;
        result = 31 * result + proteins;
        return result;
    }
}
