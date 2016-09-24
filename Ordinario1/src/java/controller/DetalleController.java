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
import dao.DetalleExamenDAOImp;
import model.Detalle;
import dao.DetalleExamenDAO;

public class DetalleController extends HttpServlet {

    private final String LISTAR_DETALLES = "/lista_detalles.jsp";
    private final String AGREGAR_CAMBIAR_DETALLE = "detalle.jsp";
    private DetalleExamenDAO dao;

    public DetalleController() {
        dao = new DetalleExamenDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";

        response.getWriter().println(action);  
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTAR_DETALLES;
            int idDetalle = Integer.parseInt(request.getParameter("id_detalle"));
            dao.borrarDetalle(idDetalle);
            request.setAttribute("detalles", dao.desplegarDetalles());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR_DETALLE;
            int idDetalle = Integer.parseInt(request.getParameter("id_detalle"));
            
            Detalle detalle = dao.elegirDetalle(idDetalle);
            System.out.println(detalle);
            request.setAttribute("detalle", dao.desplegarDetalles());
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR_DETALLE;
        } else {
            forward = LISTAR_DETALLES;
            request.setAttribute("detalles", dao.desplegarDetalles());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Detalle detalle = new Detalle();
        detalle.setContenido(Integer.parseInt(request.getParameter("contenido")));
        detalle.setResultado(Integer.parseInt(request.getParameter("resultado")));
        detalle.setPregunta(Integer.parseInt(request.getParameter("pregunta")));
        detalle.setExamenDepartamental(request.getParameter("examenDepartamental"));
        detalle.setRespuesta(request.getParameter("respuesta"));

        String idDetalle = request.getParameter("id_detalle");

        if (idDetalle == null || idDetalle.isEmpty()) {
            dao.intertarDetalle(detalle);
        } else {
            detalle.setIdDetalle(Integer.parseInt(idDetalle));
            dao.cambiarDetalle(detalle);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTAR_DETALLES);
        request.setAttribute("detalles", dao.desplegarDetalles());
        view.forward(request, response);

    }
}
