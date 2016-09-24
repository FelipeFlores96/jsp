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
import model.Detalle;
import util.UtilDB;

/**
 *
 * @author Felipe
 */
public class DetalleExamenDAOImp implements DetalleExamenDAO {

    private Connection connection;

    public DetalleExamenDAOImp() {
        connection = UtilDB.getConnection();

    }

    @Override
    public void intertarDetalle(Detalle detalle) {
        String sql = "INSERT INTO detalle (contenido,resultado,pregunta,examendepartamental,respuesta)"
                + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, detalle.getContenido());
            ps.setInt(2, detalle.getResultado());
            ps.setInt(3, detalle.getPregunta());
            ps.setString(4, detalle.getExamenDepartamental());
            ps.setString(5, detalle.getRespuesta());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarDetalle(int id_detalle) {
        String sql = "DELETE FROM detalle WHERE id_detalle=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_detalle);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarDetalle(Detalle detalle) {
        String sql = "UPDATE detalle SET contenido=?, resultado=?, pregunta=?, examendepartamental=?, respuesta=?"
                + " WHERE id_detalle=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, detalle.getContenido());
            ps.setInt(2, detalle.getResultado());
            ps.setInt(3, detalle.getPregunta());
            ps.setString(4, detalle.getExamenDepartamental());
            ps.setString(5, detalle.getRespuesta());
            ps.setInt(6, detalle.getIdDetalle());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Detalle> desplegarDetalles() {
        List<Detalle> detalles = new ArrayList<Detalle>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM detalle");
            while (rs.next()) {

                Detalle detalle = new Detalle
                        (rs.getInt("id_detalle"),
                        rs.getInt("contenido"),
                        rs.getInt("resultado"),
                        rs.getInt("pregunta"),
                        rs.getString("examendepartamental"),
                        rs.getString("respuesta")
                );
                detalles.add(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;

    }

    @Override
    public Detalle elegirDetalle(int idDetalle) {
        Detalle detalle = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM detalle_examen "
                    + " WHERE id_detalle=?");
            ps.setInt(1, idDetalle);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                detalle = new Detalle(
                        rs.getInt("in_detalle"),
                        rs.getInt("contenido"),
                        rs.getInt("resultado"),
                        rs.getInt("pregunta"),
                        rs.getString("examendepartamental"),
                        rs.getString("respuesta")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(detalle);
        return detalle;
    }

}
