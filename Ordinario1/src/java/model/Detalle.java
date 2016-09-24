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
public class Detalle {

    private int idDetalle;
    private int contenido;
    private int resultado;
    private int pregunta;
    private String examenDepartamental;
    private String respuesta;

    public Detalle(int idDetalle, int contenido, int resultado, int pregunta, String respuesta, String examenDepartamental) {
        this.idDetalle = idDetalle;
        this.contenido = contenido;
        this.resultado = resultado;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.examenDepartamental = examenDepartamental;
    }

    public Detalle() {
        this(0, 0, 0, 0, "", "");
    }

    public void setExamenDepartamental(String examenDepartamental) {
        this.examenDepartamental = examenDepartamental;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getPregunta() {
        return pregunta;
    }

    public int getResultado() {
        return resultado;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public int getContenido() {
        return contenido;
    }

    public String getExamenDepartamental() {
        return examenDepartamental;
    }

    public String getRespuesta() {
        return respuesta;
    }

    @Override
    public String toString() {
        return "Detalle{" + "idDetalle=" + idDetalle + ", contenido=" + contenido
                + ", resultado=" + resultado + ", pregunta=" + pregunta
                + ", examenDepartamental=" + examenDepartamental + ", respuesta=" + respuesta + '}';
    }

}
