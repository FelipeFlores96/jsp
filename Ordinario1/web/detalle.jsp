<%-- 
    Document   : profesor
    Created on : 21/09/2016, 10:34:16 AM
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Profesores</title>
    </head>
    <body>
        <form action="DetalleController" method="post">
            <fieldset> 
                <legend> Detalle de Examen </legend>
                <div>
                    <label for="idDetalle">ID Detalle de Examen </label>
                    <input type="text" name="idDetalle" placeholder="Ingresa el ID" values="${detalle.idDetalle}" readonly="readonly">
                </div>
                <div>
                    <label for="contenido">Contenido: </label>
                    <input type="number" name="contenido" placeholder="Indica la clave del contenido" values="${detalle.contenido}">
                </div>
                <div>
                    <label for="resultado">Resultado: </label>
                    <input type="number" name="resultado" placeholder="Ingresa el resultado" values="${detalle.resultado}">
                </div>
                <div>
                    <label for="pregunta">Pregunta: </label>
                    <input type="number" name="pregunta" placeholder="Inserta el número de pregunta" values="${detalle.pregunta}">
                </div>
                <div>
                    <label for="examenDepartamental">Examen Departamental: </label>
                    <input type="text" name="examenDepartamental" placeholder="Inserta el examen departamental" values="${detalle.examenDepartamental}">
                </div>
                <div>
                    <label for="respuesta">Respuesta: </label>
                    <input type="text" name="respuesta" placeholder="Inserta tu respuesta" values="${detalle.respuesta}">
                </div>
                <div>
                    <input type="submit" values="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
