/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Modelo;
import negocio.Representante;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        int cargo = 2;
        String usuario = request.getParameter("username");
        String contrasena = request.getParameter("pass");
       // String radioButRep = request.getParameter("cargoRep");
       // String radioCli = request.getParameter("cargoCli");
        String radioButRep = request.getParameter("cargo");
         System.out.println(radioButRep);
        if (radioButRep.equals("representante")) {
            cargo = 0;
        } else {
            if (radioButRep.equals("cliente")) {
                cargo = 1;
            } else {
                cargo = 2;
            }
        }
       

        String err2 = autenticar(usuario, contrasena, cargo);
        System.out.println("servlet.Login.processRequest() esto es " + err2 );
        
        if (err2.equals("true")) {
            response.sendRedirect("servletRegistroCliente.jsp");
            
        } else {
            if (err2.equals("1")) {
               response.sendRedirect("indexCarrito.jsp"); 
            } else {

                request.getSession().setAttribute("reg1", err2);
                response.sendRedirect("ErrorLogCli.jsp");
                System.out.println("servlet.Login.processRequest() errorrrrrrr");
            }
        }
    }

    public String autenticar(String nombre, String contrasena, int perfil) throws SQLException {
        Representante auxRep=new Representante();
        auxRep.setNombre(nombre);
        auxRep.setContrasena(contrasena);
        String res="nada";
        if (perfil == 0) {
            res = model.getInstance().getRdao().autenticacionrep(auxRep);
        } else {
            if (perfil == 1) {
                res = model.getInstance().getCdao().autenticacioCli(nombre, Integer.parseInt(contrasena));
            } else {
                res = "nada";
            }
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
