<%-- 
    Document   : lista_categories
    Author     : Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
    </head>
    <body>
        <table>
            <thead>
                <th>  ID Category: </th>
                <th>  Name:    </th>
                <th>  Description: </th>
                <th>  Picture: </th>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <td>${category.idCategory}</td>
                        <td>${category.name}</td>
                        <td>${category.description}</td>
                        <td>${category.picture}</td>
                        <td> 
                            <a href="CategoryController?action=cambiar&id_category=${category.idCategory}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="CategoryController?action=borrar&id_category=${category.idCategory}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="CategoryController?action=agregar">Agregar Category</a>
        </p>
    </body>
</html>
