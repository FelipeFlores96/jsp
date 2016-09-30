/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Felipe
 */
public class Category {

    private int idCategory;
    private String name;
    private String description;
    private String picture;


    public Category(int idCategory, String name, String description, String picture) {
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public Category() {
        this(0, "", "", "");
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", name=" + name + ", description=" + description + ", picture=" + picture + '}';
    }

    

}
