/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Detalle;

/**
 *
 * @author Felipe
 */
public interface DetalleExamenDAO {
    void intertarDetalle(Detalle detalle);
    void borrarDetalle(int idDetalle);
    void cambiarDetalle(Detalle detalle);
    
    List<Detalle> desplegarDetalles();
    Detalle elegirDetalle (int idDetalle);
    
}
