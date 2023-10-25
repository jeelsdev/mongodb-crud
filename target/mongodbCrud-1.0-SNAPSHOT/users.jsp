
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>JSP Page</title>
        <style>
            ::backdrop {
                background-image: black;
                opacity: 0.90;
            </style>
        </head>
        <body>
            <div class="container" style="margin-top: 20px;">
                <dialog style="width: 50%;" class="border border-1">

                    <form action="/users" method="POST">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Email address</label>
                            <input name="email" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Email">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                            <input name="name" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre">
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
                    </dialog>
                    <div class="d-flex justify-content-between">
                        <div></div>
                        <button id="showRegister" class="btn btn-success">Registrar</button>
                    </div>
                    <table class="table caption-top">
                        <caption class="uppercase">Lista de usuarios</caption>
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">name</th>
                                <th scope="col">Lastname</th>
                                <th scope="col">Email</th>
                                <th scope="col">Telefono</th>
                                <th scope="col">Edad</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${usuarios}">
                                <tr>

                                    <th scope="row"><c:out value="${user.id}"/></th>
                                    <td><c:out value="${user.name}"/></td>
                                    <td><c:out value="${user.lastname}"/></td>
                                    <td><c:out value="${user.email}"/></td>
                                    <td><c:out value="${user.phone}"/></td>
                                    <td><c:out value="${user.age}"/></td>
                                    <td class="d-flex">
                                        <a href="/users?action=edit&id=<c:out value="${user.id}"/>" class="btn btn-primary">editar</a>
                                        <form action="/users" method="POST">
                                            <input type="hidden" name="_method" value="DELETE">
                                            <button type="submit" class="btn btn-danger">eliminar</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <<script>
                    const dialog = document.querySelector("dialog");
                    const showButton = document.querySelector("#showRegister");
                    const closeButton = document.querySelector("#btnClose");

                    // "Show the dialog" button opens the dialog modally
                    showButton.addEventListener("click", () => {
                        dialog.showModal();
                    });

                    // "Close" button closes the dialog
                    closeButton.addEventListener("click", () => {
                        dialog.close();
                    });
                </script>
            </body>
        </html>
