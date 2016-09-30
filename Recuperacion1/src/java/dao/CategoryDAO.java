/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Category;

/**
 *
 * @author Felipe
 */
public interface CategoryDAO {
    void insertarCategory(Category category);
    void borrarCategory(int idCategoryBorrar);
    void cambiarCategory(Category category);
    
    List<Category> desplegarCategory();
    Category elegirCategory(int idCategoryElegir);
    
}
