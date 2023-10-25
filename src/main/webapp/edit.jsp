<%-- 
    Document   : edit
    Created on : 25 oct. 2023, 16:01:51
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="/users" method="POST">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Email address</label>
                            <input name="email" type="text" value="<c:out value="${user.email}"/>" class="form-control" id="exampleFormControlInput1" placeholder="Email">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                            <input name="name" type="text" value="<c:out value="${user.name}"/>" class="form-control" id="exampleFormControlInput1" placeholder="Nombre">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Apellido</label>
                            <input name="lastname" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Apellido">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Edad</label>
                            <input name="age" type="number" class="form-control" id="exampleFormControlInput1" placeholder="Edad">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Telefono</label>
                            <input name="phone" type="number" class="form-control" id="exampleFormControlInput1" placeholder="Eeléfono">
                        </div>
                        <div class="mb-3 d-flex justify-content-between">
                            <div></div>
                            <div>
                                <button type="button" id="btnClose" class="btn btn-secondary mr-3" style="margin-right: 10px">Cancelar</button>
                                    <input type="submit" class=" btn btn-primary" id="exampleFormControlInput1" value="Guardar">

                                </div>
                            </div>
                        </form>
        </div>
    </body>
</html>
