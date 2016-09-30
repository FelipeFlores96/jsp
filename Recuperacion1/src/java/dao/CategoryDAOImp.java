/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import util.UtilDB;

/**
 *
 * @author Felipe
 */
public class CategoryDAOImp implements CategoryDAO {

    private Connection connection;

    public CategoryDAOImp() {
        connection = UtilDB.getConnection();

    }

    @Override
    public void insertarCategory(Category category) {
        String sql = "INSERT INTO categoria (name,description,picture)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setString(3, category.getPicture());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarCategory(int idCategoryBorrar) {
        String sql = "DELETE FROM categoria WHERE id_category=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCategoryBorrar);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarCategory(Category category) {
        String sql = "UPDATE categoria SET name=?, description=?, picture=?"
                + " WHERE id_category=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setString(3, category.getPicture());
            ps.setInt(4, category.getIdCategory());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> desplegarCategory() {
        List<Category> categories = new ArrayList<Category>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM categoria");
            while (rs.next()) {

                Category category = new Category
                        (rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("picture")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;

    }

    @Override
    public Category elegirCategory(int idCategoryElegir) {
        Category category = new Category();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM categoria "
                    + " WHERE id_category=?");
            ps.setInt(1, idCategoryElegir);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                category = new Category(
                        rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("picture")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(category);
        return category;
    }

}
