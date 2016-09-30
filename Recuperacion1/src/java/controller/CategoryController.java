/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CategoryDAOImp;
import model.Category;
import dao.CategoryDAO;

public class CategoryController extends HttpServlet {

    private final String LISTAR_CATEGORY = "/lista_category.jsp";
    private final String AGREGAR_CAMBIAR = "category.jsp";
    private CategoryDAO dao;

    public CategoryController() {
        dao = new CategoryDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";

        response.getWriter().println(action);  
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTAR_CATEGORY;
            int idCategory = Integer.parseInt(request.getParameter("id_category"));
            dao.borrarCategory(idCategory);
            request.setAttribute("categories", dao.desplegarCategory());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idCategory = Integer.parseInt(request.getParameter("id_category"));
            
            Category category = dao.elegirCategory(idCategory);
            System.out.println(category);
            request.setAttribute("category", category);
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTAR_CATEGORY;
            request.setAttribute("categories", dao.desplegarCategory());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Category category = new Category();
        category.setName(request.getParameter("name"));
        category.setDescription(request.getParameter("description"));
        category.setPicture(request.getParameter("picture"));


        String idCategory = request.getParameter("idCategory");

        if (idCategory == null || idCategory.isEmpty()) {
            dao.insertarCategory(category);
        } else {
            category.setIdCategory(Integer.parseInt(idCategory));
            dao.cambiarCategory(category);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTAR_CATEGORY);
        request.setAttribute("categories", dao.desplegarCategory());
        view.forward(request, response);

    }
}
