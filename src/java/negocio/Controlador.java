package negocio;

import datos.*;
import java.sql.SQLException;
import javax.servlet.ServletException;

import util.RHException;

public class Controlador {

   
    
    private Representante representante;
   
    
    private Pedido pedido;
    private Venta_Producto vp;
    private Producto producto;
    private Pago pago;
    private Inventario_Producto ip;

     Controlador() {}
    
      
      
        
         
         
         
      
        

    public void buscarRepresentante(int id_reprs) {
        representante = getRdao().consultarRepresentante(id_reprs);
        System.out.println(representante.getNombre());
        System.out.println(representante.getApellido());
        System.out.println(representante.getContrasena());
    }

    public void buscarCliente(int id_cliente) {
        cliente = getCdao().consultarCliente(id_cliente);
        System.out.println(cliente.getNombre());
        System.out.println(cliente.getApellido());
        System.out.println(cliente.getContrasena());
        System.out.println(cliente.getId_representante());

    }
    
    


    
   

    public void incluirRepresentante() {

    }

    public void incluirPago(int id_pago, int id_metodo_pago, String fecha_pago) throws RHException {
        pago = new Pago();
        pago.setId_pago(id_pago);
        pago.setId_metodo_pago(id_metodo_pago);
        pago.setFecha_pago(fecha_pago);
        getSistemaVDAO().registrarPago(pago);

    }

    public void incluirPedido(int id_pedido, int id_cliente, int total_pedido, int id_pago, String estado, String fecha) throws RHException {
        pedido = new Pedido();
        pedido.setId_pedido(id_pedido);
        pedido.setId_cliente(id_cliente);
        pedido.setTotal_pedido(total_pedido);
        pedido.setId_pago(id_pago);
        pedido.setEstado(estado);
        pedido.setFecha(fecha);
        getSistemaVDAO().registrarPedido(pedido);

    }

    public void incluirVentaProduct(int id_pedido, int id_producto, int cantidad, double total_producto) throws RHException {
        vp = new Venta_Producto();
        vp.setId_pedido(id_pedido);
        vp.setId_producto(id_producto);
        vp.setCantidad(cantidad);
        vp.setTotal_producto(total_producto);
        getSistemaVDAO().registrarVentaProduc(vp);
    }

    public void actualizarStock(int cantidadVentaProduc, int id_product) throws RHException {
        ip = sistemaVDAO.ConsultarInventario(id_product);
        ip.setCantidad(ip.getCantidad() - cantidadVentaProduc);
        getSistemaVDAO().actualizarInvProduc(ip);
    }

    public void CalificarRepVenta() {

    }

    public void cambiarContrasenaRep(int pass, int reprs) throws RHException {
        representante = new Representante();
        representante.setContrasena(pass);
        representante.setId_representante(reprs);
        getRdao().actualizarContrasena(representante);
    }

}
