<%-- 
    Document   : categories
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category's Form</title>
    </head>
    <body>
        <form action="CategoryController" method="post">
            <fieldset> 
                <legend> Category </legend>
                <div>
                    <label for="idCategory">ID Category </label>
                    <input type="number" name="idCategory" placeholder="Ingresa el ID" value="${category.idCategory}" readonly="readonly">
                </div>
                <div>
                    <label for="name">Name: </label>
                    <input type="text" name="name" placeholder="Name" value="${category.name}">
                </div>
                <div>
                    <label for="description">Description: </label>
                    <input type="text" name="description" placeholder="Description" value="${category.description}">
                </div>
                <div>
                    <label for="picture">Picture: </label>
                    <input type="text" name="picture" placeholder="Picture" value="${category.picture}">
                </div>
                <div>
                    <input type="submit" value="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
