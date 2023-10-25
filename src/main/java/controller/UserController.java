/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.PersonDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.BufferedReader;
import java.util.List;

import model.Person;

/**
 *
 * @author User
 */
@WebServlet(name = "user", urlPatterns = {"/users"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action;
        RequestDispatcher dispatcher = null;
        PersonDAO personDAO = new PersonDAO();
        
        action = request.getParameter("action");
        if("edit".equals(action)){
            String id = request.getParameter("id");
            Person user = personDAO.readDocument(id);
            System.out.println(user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }else if("update".equals(action)){
            doPut(request, response);
        }else if("delete".equals(action)){
            doDelete(request, response);
        }
        
        List<Person> usuarios = personDAO.getAllUsuarios();

        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("users.jsp").forward(request, response);
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String lastname = request.getParameter("lastname");
        int age = Integer.parseInt(request.getParameter("age"));
        int phone =Integer.parseInt(request.getParameter("phone"));
       
        Person person = new Person(name, lastname, age, email, phone);
        
        try {
            PersonDAO personDAO = new PersonDAO();
            personDAO.createDocument(person);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        PersonDAO personDAO = new PersonDAO();
        List<Person> usuarios = personDAO.getAllUsuarios();

        // Puedes usar Jackson para convertir la lista de usuarios a JSON si es necesario

        // Luego, enviar la lista de usuarios a la vista JSP
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String lastname = request.getParameter("lastname");
        int age = Integer.parseInt(request.getParameter("age"));
        int phone =Integer.parseInt(request.getParameter("phone"));
       
        Person person = new Person(name, lastname, age, email, phone);
        
        try {
            PersonDAO personDAO = new PersonDAO();
            personDAO.updateDocument(id, person);
            
            List<Person> usuarios = personDAO.getAllUsuarios();

           
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            PersonDAO personDAO = new PersonDAO();
            String id = request.getParameter("id");
            personDAO.deleteDocument(id);
            
            List<Person> usuarios = personDAO.getAllUsuarios();

           
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
