/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.RepresentanteDAO;
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
import javax.swing.JOptionPane;
import negocio.Cliente;
import negocio.Controlador;
import negocio.Modelo;
import util.RHException;

/**
 *
 * @author Alejandro
  
 */@WebServlet(name = "AgregarCliente", urlPatterns = {"/AgregarCliente"})
public class AgregarCliente extends HttpServlet {
     private Cliente cliente;
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
        
        
    String idcliente = request.getParameter("id_cliente");
    String nombre=request.getParameter("nombre");
    String apellido=request.getParameter("apellido");
    String telefono=request.getParameter("telefono");
    String contraseña=request.getParameter("contrasena");
    String idrepresentante=request.getParameter("id_representante");
        PrintWriter out = response.getWriter();
        int id=Integer.parseInt(idcliente);
        int con= Integer.parseInt(contraseña);
        int idrep=Integer.parseInt(idrepresentante);
      
                       
              
             String reg2=  incluirCliente(id, nombre, apellido, telefono, con,idrep);
             
                     
            if(reg2.equals("")){
                String reg= registrarCliente(nombre ,con);   
                //String reg="";

                if(reg.equals("")){
                    //NOs devuelve a la vista  con un mensaje de exito
                    response.sendRedirect("servletRegistroCliente.jsp");
                    }else{
                    //NOs devuelve a la vista  con un mensaje de error
                        request.getSession().setAttribute("reg1", reg);
                        response.sendRedirect("ErrorRegCli.jsp");
                }
                
            }else{
                //nos devuelve a la ventana con un mensaje de error
               request.getSession().setAttribute("reg2", reg2);
             
              response.sendRedirect("ErrorRegCli.jsp");
            }
       
        
      //  c.incluirCliente(idcliente, nombre, apellido, telefono, contraseña, idrepresentante);
    }
    public String  incluirCliente(int id_cliente, String nombre, String apellido, String telefono, int contrasena, int id_reprs) throws SQLException {
        cliente = new Cliente();
        cliente.setId_cliente(id_cliente);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setContrasena(contrasena);
        cliente.setId_representante(id_reprs);
         return model.getInstance().getRdao().registrarCliente(cliente);
    }
     public String registrarCliente(String nombre, int contraseña)throws SQLException{
        cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setContrasena(contraseña);
        return model.getInstance().getRdao().crearCliente(cliente); 
       
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
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
