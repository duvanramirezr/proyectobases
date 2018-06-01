/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.RepresentanteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Controlador;
import negocio.Modelo;

/**
 *
 * @author milto
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginReServlet extends HttpServlet {
     private Modelo model;
    
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
       throws ServletException, IOException 
        {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contrasena");
        
        String auxConrep=(contraseña);
        
       
        if(autenticarRepresentante(usuario,auxConrep)){
        response.sendRedirect("inicioRep.jsp");
        
        }
        else{
             String err2=Boolean.toString(autenticarRepresentante(usuario,auxConrep));
             request.getSession().setAttribute("reg1", err2);
                 response.sendRedirect("ErrorLogRep.jsp");
        }
       
    }
    
     public boolean autenticarRepresentante(String nombre,String contrasena){
        boolean res;
        model.getInstance().getRdao().setUser(nombre);
        model.getInstance().getRdao().setContra(contrasena);
        res=model.getInstance().getRdao().autenticacionrep(nombre, contrasena);
 
        return res;
        
  
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
        processRequest(request, response);
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
