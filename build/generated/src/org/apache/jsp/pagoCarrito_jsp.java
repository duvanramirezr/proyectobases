package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.ArrayList;
import negocio.*;
import datos.*;

public final class pagoCarrito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

    Venta_Producto vp = new Venta_Producto();
     /* double ValorTotal = 0.0;
         ArrayList<Producto> lista = SistemaVDAO.obtenerProducto();
          for (Producto p : lista) {
              double valor = p.getValor();
              ValorTotal = ValorTotal + valor;
              
          }
          vp.setTotal_producto(ValorTotal);*/
    
    java.util.Date fecha = new Date();
    Pago pago = new Pago();
    //este parametro debe ser dinamico, es decir, se debe generar tipo consecutivo
    //pero lo dejo estatico para el caso
    pago.setId_pago(51551);
    if (request.getParameter("Metodo Pago") == "PSE") {
        pago.setId_metodo_pago(101);
    } else {
        if (request.getParameter("Metodo Pago") == "TCE") {
            pago.setId_metodo_pago(102);
        }
    }
    pago.setFecha_pago("05/06/2018");
    int idped=5454554;
    for(int i =0;i<10;i++){
        idped++;
    }
        
    Pedido pedido = SistemaVDAO.obtenerPedido(999);


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Carrito de compras</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Pago</h1>\r\n");
      out.write("        <div class=\"topnav\">\r\n");
      out.write("        <!--EN ESTE BLOQUE SE DEFINE LA BARRA DE NAVEGACION-->\r\n");
      out.write("        <a class=\"active\" href=\"index.jsp\">Login</a>\r\n");
      out.write("        <a class=\"active\" href=\"servletRegistroCliente.jsp\">Registrar Cliente</a>\r\n");
      out.write("        <a class=\"active\" href=\"indexCarrito.jsp\">Carro</a>\r\n");
      out.write("        <a class=\"active\" href=\"registrarProductoCarrito.jsp\">Registrar producto</a>\r\n");
      out.write("</div>\r\n");
      out.write("        <div>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <a href=\"indexCarrito.jsp\">Inicio</a> |\r\n");
      out.write("            <a href=\"registrarProductoCarrito.jsp\">Registrar Producto</a> |\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        <br >\r\n");
      out.write("        <form action=\"carritoServlet\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"accion\" value=\"RealizarPago\" />\r\n");
      out.write("            <div>\r\n");
      out.write("                <table border=\"1\">\r\n");
      out.write("                    <tr style=\"background-color: chocolate\">\r\n");
      out.write("                        <td colspan=\"4\"><center>Realizar pago</center></td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr style=\"background-color: chocolate\">\r\n");
      out.write("                        <td><center>Metodo de Pago</center></td>\r\n");
      out.write("                        <td><center>Codigo</center></td>\r\n");
      out.write("                        <td><center>Valor Total</center></td>\r\n");
      out.write("                        <td><center>Fecha de Pago</center></td>\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><center><select name=\"txtMetodo\" heigth=\"5\"><option value=\"PSE\">PSE></option><option value=\"TCE\">TCE</option></select></center></td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtCodigoPago\" value=\"\" /></td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtValor\" value=\"");
      out.print(pedido.getTotal_pedido());
      out.write("\" /></td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txFecha\" value=\"");
      out.print(pago.getFecha_pago());
      out.write("\" /></td>\r\n");
      out.write("                       \r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                    <br>    \r\n");
      out.write("                    <input type=\"submit\" value=\"Realizar Pago\" name=\"btnPago\"/>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("     \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
