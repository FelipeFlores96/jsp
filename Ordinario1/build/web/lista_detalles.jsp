<%-- 
    Document   : lista_detalles
    Created on : 21/09/2016, 10:34:46 AM
    Author     : Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles de Examen</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>  ID Detalle de Examen</tr>
                <tr>  Contenido</tr>
                <tr>  Resultado</tr>
                <tr>  Pregunta</tr>
                <tr>  Examen Departamental</tr>
                <tr>  Respuesta</tr>
            </thead>
            <tbody>
                <c:forEach items="${detalles}" var="detalle">
                    <tr>
                        <td>${detalle.idDetalle}</td>
                        <td>${detalle.contenido}</td>
                        <td>${detalle.resultado}</td>
                        <td>${detalle.pregunta}</td>
                        <td>${detalle.examenDepartamental}</td>
                        <td>${detalle.respuesta}</td>
                        <td> 
                            <a href="DetalleController?action=cambiar&id_detalle=${detalle.idDetalle}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="DetalleController?action=borrar&id_detalle=${detalle.idDetalle}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="DetalleController?action=agregar">Agregar Detalle de Examen</a>
        </p>
    </body>
</html>
