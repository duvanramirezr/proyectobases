package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import negocio.*;
import servlet.*;
import java.util.*;

public final class registrarProductoCarrito_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("       <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("        <title>NATAME</title>\r\n");
      out.write("        <!--LAS SIGUIENTES LINEAS SE USAN PARA LLAMAR EL CSS QUE SE DEFINIO PARA MEJORAR LA INTERFAZ-->\r\n");
      out.write("\r\n");
      out.write("        <!--===============================================================================================-->\t\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/Linearicons-Free-v1.0.0/icon-font.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\r\n");
      out.write("        <!--===============================================================================================-->\t\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\t\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"topnav\">\r\n");
      out.write("        <!--EN ESTE BLOQUE SE DEFINE LA BARRA DE NAVEGACION-->\r\n");
      out.write("        <a class=\"active\" href=\"index.jsp\">Login</a>\r\n");
      out.write("        <a class=\"active\" href=\"servletRegistroCliente.jsp\">Registrar Cliente</a>\r\n");
      out.write("        <a class=\"active\" href=\"indexCarrito.jsp\">Carro</a>\r\n");
      out.write("        <a class=\"active\" href=\"registrarProductoCarrito.jsp\">Registrar producto</a>\r\n");
      out.write("</div> \r\n");
      out.write("    \r\n");
      out.write("        <div class=\"limiter\">\r\n");
      out.write("        <!--EN ESTE BLOQUE SE DEFINEN LOS CAMPOS NECESARIOS PARA REALIZAR EL REGISTRO DE UN NUEVO PRODUCTO-->\r\n");
      out.write("\t\t<div class=\"container-login100\" style=\"background-image: url('images/bg-01.jpg');\">\r\n");
      out.write("\t\t\t<div class=\"wrap-login100 p-t-30 p-b-50\">\r\n");
      out.write("\t\t\t\t<span class=\"login100-form-title p-b-41\">\r\n");
      out.write("\t\t\t\t\tREGISTRAR PRODUCTO\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t<form class=\"login100-form validate-form p-b-33 p-t-5\" action=\"Registrar\" method=\"post\" >\r\n");
      out.write("                                    <!--EN ESTA SECCION SE DEFININEN LOS CAMPOS QUE EL USUARIO DEBE LLENAR PARA SER ENVIADOS A LA BASE DE DATOS Y REGISTRAR EL NUEVO PRODUCTO-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Enter idproducto\">\r\n");
      out.write("                                        <!--CAMPO PARA PODER DIGITAR EL ID DEL PRODUCTO-->\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"idproducto\" placeholder=\"ID Producto\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe82a;\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Enter nombre\">\r\n");
      out.write("                                            <!--CAMPO PARA PODER DIGITAR EL NOMBRE DEL NUEVO CLIENTE-->\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"nombre\" placeholder=\"Nombre\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe82a;\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                     \r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Enter apellido\">\r\n");
      out.write("                                            <!--CAMPO PARA PODER DIGITAR EL APELLIDO DEL NUEVO CLIENTE-->\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"apellido\" placeholder=\"Apellido\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe82a;\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Enter telefono\">\r\n");
      out.write("                                            <!--CAMPO PARA PODER DIGITAR EL NUMERO DE TELEFONO DEL NUEVO CLIENTE-->\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"telefono\" placeholder=\"Telefono\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe83a;\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Enter contraseña\">\r\n");
      out.write("                                        <!--CAMPO PARA PODER DIGITAR LA CONTRASEÑA DEL NUEVO CLIENTE-->\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"contrasena\" placeholder=\"Contraseña\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe80f;\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Enter idrepresentante\">\r\n");
      out.write("                                        <!--CAMPO PARA PODER DIGITAR EL ID DEL REPRESENTANTE QUE REGISTRA AL NUEVO CLIENTE-->\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"idrepresentante\" placeholder=\"Id representante\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe82b;\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn m-t-32\">\r\n");
      out.write("                                        <!--BOTON QUE PERMITE ENVIAR A LA BASE DE DATOS LA INFORMACION QUE SE DIGITO EN LOS CAMPOS ANTERIORES PARA REALIZAR EL REGISTRO DEL NUEVO CLIENTE-->\r\n");
      out.write("\t\t\t\t\t\t<button class=\"login100-form-btn\">\r\n");
      out.write("\t\t\t\t\t\t\tRegistrar\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"carritoServlet\" method=\"post\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <input type=\"hidden\" name=\"accion\" value=\"RegistrarProducto\" />\r\n");
      out.write("                <table border=\"1\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>ID</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtCodigo\" value=\"\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Nombre</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtNombre\" value=\"\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Categoria</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtCategoria\" value=\"0\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Valor</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtValor\" value=\"0\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Detalle</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txtDetalle\" value=\"\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td><input type=\"submit\" value=\"Registrar\" name=\"btnRegistrar\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <script src=\"vendor/animsition/js/animsition.min.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <script src=\"vendor/bootstrap/js/popper.js\"></script>\r\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <script src=\"vendor/select2/select2.min.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <script src=\"vendor/daterangepicker/moment.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <script src=\"vendor/countdowntime/countdowntime.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
