package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import negocio.*;

import util.RHException;
import util.ServiceLocator;

public class SistemaVDAO {
     private String user;
     private String contra;

    public void setUser(String user) {
        this.user = user;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
     
/*
    public void registrarRepresentante(Representante representante) throws RHException {
        try {
 
            String strSQL = "INSERT INTO REPRESENTANTES (ID_REPRESENTANTE, NOMBRE, APELLIDO, TELEFONO, CONTRASENA, ID_REGION, ID_CLASIFICACION) VALUES (?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, representante.getId_representante());
            prepStmt.setString(2, representante.getNombre());
            prepStmt.setString(3, representante.getApellido());
            prepStmt.setString(4, representante.getTelefono());
            prepStmt.setInt(5, Integer.parseInt(representante.getContrasena());
            prepStmt.setInt(6, representante.getId_region());
            prepStmt.setInt(7, representante.getId_clasificacion());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new RHException("Representante", "No pudo crear representante" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
*/
    public void registrarPago(Pago pago) throws RHException {
        try {

            String strSQL = "INSERT INTO PAGOS (ID_PAGO, ID_METODO_PAGO, FECHA_PAGO) VALUES (?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, pago.getId_pago());
            prepStmt.setInt(2, pago.getId_metodo_pago());
            prepStmt.setString(3, pago.getFecha_pago());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new RHException("Pago", "No pudo crear pago" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void registrarPedido(Pedido pedido) throws RHException {
        try {

            String strSQL = "INSERT INTO PEDIDOS (ID_PEDIDO, CEDULA_CLIENTE, TOTAL_PEDIDO, ID_PAGO, ESTADO, FECHA) VALUES (?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, pedido.getId_pedido());
            prepStmt.setInt(2, pedido.getId_cliente());
            prepStmt.setInt(3, pedido.getTotal_pedido());
            prepStmt.setInt(4, pedido.getId_pago());
            prepStmt.setString(5, pedido.getEstado());
            prepStmt.setString(6, pedido.getFecha());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new RHException("Pedido", "No pudo crear pedido" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void registrarVentaProduc(Venta_Producto vp) throws RHException {
        try {

            String strSQL = "INSERT INTO PRODUCTOS(ID_PEDIDO, ID_PRODUCTO, CANTIDAD, TOTAL_PRODUCTO) VALUES (?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, vp.getId_pedido());
            prepStmt.setInt(2, vp.getId_producto());
            prepStmt.setInt(3, vp.getCantidad());
            prepStmt.setDouble(4, vp.getTotal_producto());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new RHException("Venta", "No pudo crear venta" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

 /*   public Inventario_Producto ConsultarInventario(int id_product) {
        Inventario_Producto ip = new Inventario_Producto();
        try {
            String strSQL = "SELECT ID_PRODUCTO, CANTIDAD FROM NATAME.INVENTARIO_PRODUCTO WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_product);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                ip.setProducto(id_product);
                ip.setCantidad(rs.getInt("CANTIDAD"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro inventario");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO INVENTARIO: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return ip;
    }

    public Venta_Producto ConsultarVentaProduc(int id_product) {
        Venta_Producto vp = new Venta_Producto();
        try {
            String strSQL = "SELECT ID_PRODUCTO, CANTIDAD FROM NATAME.VENTA_PRODUCTO WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_product);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                vp.setId_producto(id_product);
                vp.setCantidad(rs.getInt("CANTIDAD"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la venta");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO VENTA: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return vp;
    }

    public void actualizarInvProduc(Inventario_Producto ip) throws RHException {
        try {
            String strSQL = "UPDATE NATAME.INVENTARIO_PRODUCTO SET CANTIDAD = ? WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, ip.getCantidad());
            prepStmt.setInt(2, ip.getProducto());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            throw new RHException("Inventario", "Inventario NO cambiado" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }*/
     public Inventario_Producto ConsultarInventario(int id_product) {
        Inventario_Producto ip = new Inventario_Producto();
        try {
            String strSQL = "SELECT ID_PRODUCTO, CANTIDAD FROM INVENTARIOS WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_product);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                ip.setProducto(id_product);
                ip.setCantidad(rs.getInt("Cantidad"));
            } else {
               // JOptionPane.showMessageDialog(null, "No se encontro inventario");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO INVENTARIO: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return ip;
    }

    public Venta_Producto ConsultarVentaProduc(int id_product) {
        Venta_Producto vp = new Venta_Producto();
        try {
            String strSQL = "SELECT ID_PRODUCTO, CANTIDAD FROM VENTAS WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_product);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                vp.setId_producto(id_product);
                vp.setCantidad(rs.getInt("CANTIDAD"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la venta");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO VENTA: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return vp;
    }

    public void actualizarInvProduc(Inventario_Producto ip) throws RHException {
        Producto p = new Producto();
        try {
            
            
            String strSQL = "UPDATE INVENTARIOS SET CANTIDAD = ? WHERE ID_PRODUCTO = ?" ;
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
           //ResultSet rs = prepStmt.executeQuery();
          // prepStmt.executeQuery();
            //while(rs.next()){
                System.out.println("Prueba1: " + ip.getCantidad());
                prepStmt.setInt(1, ip.getCantidad());
                System.out.println("Prueba2: " + ip.getProducto());
                prepStmt.setInt(2, ip.getProducto());
            //}    
            prepStmt.executeUpdate();
            prepStmt.close();
            
            
            ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            throw new RHException("Inventario", "Inventario NO cambiado" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public  ArrayList<Producto> obtenerProducto() throws RHException {
         ArrayList<Producto> lista = new ArrayList<Producto>();
          
    try{
        String strSQL = "SELECT * FROM PRODUCTOS";
        Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);   
         PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
         
         ResultSet rs = prepStmt.executeQuery();
        
        while(rs.next()){
            Producto p = new Producto();
            
            p.setId_producto(rs.getInt("ID_PRODUCTO"));
            p.setNombre(rs.getString("NOMBRE"));
            p.setId_categoria(rs.getInt("ID_CATEGORIA"));
            p.setValor(rs.getDouble("VALOR"));
            p.setDetalle(rs.getString("DETALLE"));
            
            lista.add(p);
        }
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
    } catch (Exception e) {
            throw new RHException("Producto", "Producto No ingresado" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        
    return lista;
    }
    
    public  Producto obtenerProducto(int id_product) {
        Producto p = new Producto();
        try {
            String strSQL = "SELECT ID_PRODUCTO, NOMBRE, ID_CATEGORIA, VALOR, DETALLE FROM PRODUCTOS  WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_product);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                p.setId_producto(id_product);
                p.setNombre(rs.getString("NOMBRE"));
                p.setId_categoria(rs.getInt("ID_CATEGORIA"));
                p.setValor(rs.getDouble("VALOR"));
                p.setDetalle(rs.getString("DETALLE"));
            } 
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO VENTA: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return p;
    }
    
    public void registrarProducto(Producto p) throws RHException {
        try {

            String strSQL = "INSERT INTO PRODUCTOS (ID_PRODUCTO, NOMBRE, ID_CATEGORIA, VALOR, DETALLE) VALUES (?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, p.getId_producto());
            prepStmt.setString(2, p.getNombre());
            prepStmt.setInt(3, p.getId_categoria());
            prepStmt.setDouble(4, p.getValor());
            prepStmt.setString(5, p.getDetalle());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new RHException("Producto", "No pudo crear producto" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        
       
    }
    
     public void actualizarProducto(Producto p) throws RHException {
        try {
            String strSQL = "UPDATE PRODUCTOS SET NOMBRE = ?, ID_CATEGORIA = ?, VALOR = ?, DETALLE = ? WHERE ID_PRODUCTO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, p.getNombre());
            prepStmt.setInt(2, p.getId_categoria());
            prepStmt.setDouble(3, p.getValor());
            prepStmt.setString(4, p.getDetalle());
            prepStmt.setInt(5, p.getId_producto());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            throw new RHException("Inventario", "Inventario NO cambiado" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
     
         public Pedido obtenerPedido(int id_pedido) {
        Pedido p = new Pedido();
        try {
            String strSQL = "SELECT TOTAL_PEDIDO FROM PEDIDOS WHERE ID_PEDIDO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user, contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_pedido);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
               
                p.setTotal_pedido(rs.getInt("TOTAL_PEDIDO"));
               
            } 
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO VENTA PRODUCTO: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return p;
    }

}
