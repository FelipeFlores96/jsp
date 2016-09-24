/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Profesor;

/**
 *
 * @author Felipe
 */
public interface ProfesorDAO {
    void agregarProfesor(Profesor profesor);
    void borrarProfesor(int idProfesor);
    void cambiarProfesor(Profesor profesor);
    
    List<Profesor> desplegarProfesores();
    Profesor elegirProfesor (int idProfesor);
    
}
