/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.ClienteDAO;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Producto;
import negocio.Inventario_Producto;
import datos.SistemaVDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import negocio.Cliente;
import negocio.Modelo;
import negocio.Pago;
import negocio.Pedido;
import negocio.Venta_Producto;
import util.RHException;

/**
 *
 * @author LINA
 */
@WebServlet(name = "carritoServlet", urlPatterns = {"/carritoServlet"})
public class carritoServlet extends HttpServlet {
    Inventario_Producto invAct;
    Modelo model;
    //Para controlar peticiones del tipo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (RHException ex) {
            Logger.getLogger(carritoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Para controlar peticiones del tipo POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (RHException ex) {
            Logger.getLogger(carritoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Un metodo que recibe todas las peticiones a si sea GET y POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RHException {
        //La accion se va a guardar en un caja de texto oculto que nos dira que accion
        //debemos hacer
         
        String accion = request.getParameter("accion");
        if (accion.equals("RegistrarProducto")) {
            this.registrarProducto(request, response);
        } else if (accion.equals("ModificarProducto")) {
            this.actualizarProducto(request, response);
        } else if (accion.equals("RealizarVenta")){
           
           this.actualizarInvProducto(request, response);
           this.capturarVenta(request, response);
           // this.actualizarInvProducto(request, response);
        }
        /* else if (accion.equals("AnadirCarrito")) {
            this.añadirCarrito(request, response);
        } else if (accion.equals("RegistrarVenta")) {
            this.registrarVenta(request, response);
        }*/

    }
    //Metodo que sirve para registrar un producto 
    private void registrarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RHException {
        Producto p = new Producto();
        //request.getParameter --> Sirve para obtener los valores de las cajas de texto
        p.setId_producto(Integer.parseInt(request.getParameter("txtCodigo")));
        p.setNombre(request.getParameter("txtNombre").toUpperCase());
        p.setId_categoria(Integer.parseInt(request.getParameter("txtCategoria")));
        p.setValor(Double.parseDouble(request.getParameter("txtValor")));
        p.setDetalle(request.getParameter("txtDetalle"));
       model.getInstance().getSistemaVDAO().registrarProducto(p);  
       response.sendRedirect("indexCarrito.jsp");
        
    }
    //Metodo que sirve para actualizar un producto
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RHException {
        Producto p = new Producto();
        p.setId_producto(Integer.parseInt(request.getParameter("txtCodigo")));
        p.setNombre(request.getParameter("txtNombre").toUpperCase());
        p.setId_categoria(Integer.parseInt(request.getParameter("txtCategoria")));
        p.setValor(Double.parseDouble(request.getParameter("txtValor")));
        p.setDetalle(request.getParameter("txtDetalle"));
        model.getInstance().getSistemaVDAO().actualizarProducto(p);
        response.sendRedirect("indexCarrito.jsp");
        
    }
     private void actualizarInvProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RHException {
    
          ArrayList<Producto> lista = model.getInstance().getSistemaVDAO().obtenerProducto();
          for (Producto p : lista) {
             Inventario_Producto inv = new Inventario_Producto();
             invAct = model.getInstance().getSistemaVDAO().ConsultarInventario(p.getId_producto());
              System.out.println("ID prodc"+p.getId_producto());
             int cantidad = invAct.getCantidad() - 1;
             inv.setCantidad(cantidad);
              System.out.println("Cantidad inv"+cantidad);
             inv.setProducto(p.getId_producto());
            
             
             model.getInstance().getSistemaVDAO().actualizarInvProduc(inv);
              
          }
    /*     
        Inventario_Producto inv = new Inventario_Producto();
        
        invAct = SistemaVDAO.ConsultarInventario(Integer.parseInt(request.getParameter("txtCodigo")));
         
        int cantidad = invAct.getCantidad() -1;
        inv.setCantidad(cantidad);
        
        inv.setProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        
       */ 
         
        
  /*      String check;
         ArrayList<Producto> lista = SistemaVDAO.obtenerProducto();
          for (Producto p : lista) {
              check =request.getParameter("checkComprar");
              System.out.println("check ="+check);
               if(check == "1"){
                   System.out.println("Valor3 :" + p.getValor());
               }else{
                   
               }       
                //  
              
          }*/
          
        
      //  capturarVenta(request, response);
       
         
      //response.sendRedirect("pagoCarrito.jsp");
        
    }
     
     private void realizarCompra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RHException {
         
        Venta_Producto vp = new Venta_Producto(); 
         double ValorTotal = 0.0;
         ArrayList<Producto> lista = model.getInstance().getSistemaVDAO().obtenerProducto();
          for (Producto p : lista) {
              double valor = p.getValor();
              ValorTotal = ValorTotal + valor;
              
          }
          vp.setTotal_producto(ValorTotal);
     
     }
     private void capturarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RHException {
         
         ArrayList<Producto> lista = model.getInstance().getSistemaVDAO().obtenerProducto();
         //Capturar Pago
          java.util.Date fecha = new Date();
            Pago pago = new Pago();
             //este parametro debe ser dinamico, es decir, se debe generar tipo consecutivo
             //pero lo dejo estatico para el caso
             pago.setId_pago(123);
           /*  if (request.getParameter("Metodo Pago") == "PSE") {
                 pago.setId_metodo_pago(101);
             } else {
                 if (request.getParameter("Metodo Pago") == "TCE") {
                     pago.setId_metodo_pago(102);
                 }
             }*/
             //pago.setId_metodo_pago(Integer.parseInt(request.getParameter("txtMetodo")));
             pago.setFecha_pago(String.valueOf(fecha));
             
          //Capturar venta
            double valor_tatal = 0;
            double valor_final = 0;
            int cant_produc = 0;

            Venta_Producto vp = new Venta_Producto();
            ArrayList<Venta_Producto> pedidoProduc = new ArrayList<Venta_Producto>();
            String check ;
            for (int i = 0; i < lista.size(); i++) {
                check = request.getParameter("checkComprar");
                System.out.println("*****"+(check=="1"));
                System.out.println("*****"+check);
                System.out.println("ids"+lista.get(i).getId_producto());
                if (check.equals("1")) {
                    System.out.println("Entro");
                    System.out.println("-----"+lista.get(i).getId_producto());
                    vp.setId_producto(lista.get(i).getId_producto());
                    
                    //ya que si se cumple la condiccion de check y como lista alberga toda la consulta en un orden especifico
                    //se puede traer el valor correspondiente de lista y su atributo
                    vp.setCantidad(Integer.parseInt(request.getParameter("Cantidad")));

                    valor_tatal = Double.parseDouble(request.getParameter("Cantidad")) * lista.get(i).getValor();
                    //esto es para acumular el total de valor por producto y generar un valor final que es la suma de todos ellos
                    vp.setTotal_producto(valor_tatal);

                    valor_final = valor_final + valor_tatal;

                    pedidoProduc.add(vp);

                    cant_produc += 1;
                }
                
            }
           
           System.out.println("NoMbRe"+negocio.Modelo.getInstance().getCdao().consultarIDCliente().getNombre());
            
            Cliente cliente = negocio.Modelo.getInstance().getCdao().consultarIDCliente();
            int cedula = cliente.getCedula_cliente();
            System.out.println("CEDULA CLIENTE: "+ cedula);
            //Capturar pedido
             Pedido pedido = new Pedido();
                        //este parametro debe ser dinamico, es decir, se debe generar en la capa web
             int idpedido=105; 
            
                        //como el que se loguea es el cliente, se debe guardar una variable con su id
                        //Y guardarla asi: int id_cliente = request.getParameter("idCliente");
                        //y eso es lo que se pasa por parametro a setId_Cliente
            pedido.setId_cliente(7412);
            pedido.setId_pedido(idpedido);
            pedido.setTotal_pedido((int) valor_final);
            pedido.setId_pago(pago.getId_pago());
            pedido.setEstado("EP");
            pedido.setFecha("05/06/2018");
            System.out.println("#####"+ pedido.getId_pedido());
            vp.setId_pedido(pedido.getId_pedido());
            System.out.println("========"+ vp.getId_pedido());
            System.out.println("========"+ vp.getId_producto());
            System.out.println("========"+ vp.getTotal_producto());
            System.out.println("=========" + vp.getCantidad());
            
            

           // SistemaVDAO.registrarPago(pago);
           System.out.println("rrrrrr"+pedido.getId_pedido());
           System.out.println("rrrrrr"+pedido.getId_cliente());
           System.out.println("rrrrrr"+pedido.getId_pago());
           System.out.println("rrrrrr"+pedido.getFecha());
           model.getInstance().getSistemaVDAO().registrarPedido(pedido);
           idpedido = idpedido+5;
           model.getInstance().getSistemaVDAO().registrarVentaProduc(vp);

         
            response.sendRedirect("pagoCarrito.jsp");
         
     }
    //Metodo que sirve para actualizar el inventario de producto
    
    //Sirve para añadir un detalle al carrito
    //La informacion del carrito de compras se guarda en una sesion
   /* private void añadirCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos la sesion actual
        HttpSession sesion = request.getSession();
        ArrayList<DetalleVenta> carrito;
        //Si no existe la sesion creamos al carrito de cmoras
        if (sesion.getAttribute("carrito") == null) {
            carrito = new ArrayList<DetalleVenta>();
        } else {
            carrito = (ArrayList<DetalleVenta>) sesion.getAttribute("carrito");
        }
        //Obtenemos el producto que deseamos añadir al carrito
        Producto p = ProductoBD.obtenerProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        //Creamos un detalle para el carrtio
        DetalleVenta d = new DetalleVenta();
        //Obtenemos los valores de la caja de texto
        d.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        d.setProducto(p);
        d.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
        //Calculamos el descuento, si es sub detalle es mayor a 50 se le hace
        //un descuento del 5% aca es donde se encuentra la logica del negocio
        double subTotal = p.getPrecio() * d.getCantidad();
        if (subTotal > 50) {
            d.setDescuento(subTotal * (5D / 100D));
        } else {
            d.setDescuento(0);
        }
        //Sirva para saber si tenemos agregado el producto al carrito de compras
        int indice = -1;
        //recorremos todo el carrito de compras
        for (int i = 0; i < carrito.size(); i++) {
            DetalleVenta det = carrito.get(i);
            if (det.getCodigoProducto() == p.getCodigoProducto()) {
                //Si el producto ya esta en el carrito, obtengo el indice dentro
                //del arreglo para actualizar al carrito de compras
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            //Si es -1 es porque voy a registrar
            carrito.add(d);
        } else {
            //Si es otro valor es porque el producto esta en el carrito
            //y vamos actualizar la 
            carrito.set(indice, d);
        }
        //Actualizamos la sesion del carrito de compras
        sesion.setAttribute("carrito", carrito);
        //Redireccionamos al formulario de culminar la venta
        response.sendRedirect("registrarVenta.jsp");
    }*/
    //Metodo que sirve para registrar toda la venta en la base de datos
/*    private void registrarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Venta v=new Venta();
        v.setCliente(request.getParameter("txtCliente").toUpperCase());
        ArrayList<DetalleVenta> detalle  = (ArrayList<DetalleVenta>) sesion.getAttribute("carrito");
        boolean rpta=VentaBD.insertarVenta(v, detalle);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se registro la venta de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se registro la venta");
        }
    }
*/
}
