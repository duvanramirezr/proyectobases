package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     

    public void registrarRepresentante(Representante representante) throws RHException {
        try {

            String strSQL = "INSERT INTO NATAME.REPRESENTANTE_VENTA (ID_REPRESENTANTE, NOMBRE, APELLIDO, TELEFONO, CONTRASENA, ID_REGION, ID_CLASIFICACION) VALUES (?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, representante.getId_representante());
            prepStmt.setString(2, representante.getNombre());
            prepStmt.setString(3, representante.getApellido());
            prepStmt.setString(4, representante.getTelefono());
            prepStmt.setInt(5, representante.getContrasena());
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

    public void registrarPago(Pago pago) throws RHException {
        try {

            String strSQL = "INSERT INTO NATAME.PAGO (ID_PAGO, ID_METODO_PAGO, FECHA_PAGO) VALUES (?,?,?)";
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

            String strSQL = "INSERT INTO NATAME.PEDIDO (ID_PEDIDO, ID_CLIENTE, TOTAL_PEDIDO, ID_PAGO, ESTADO, FECHA) VALUES (?,?,?,?,?,?)";
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

            String strSQL = "INSERT INTO NATAME.VENTA_PRODUCTO (ID_PEDIDO, ID_PRODUCTO, CANTIDAD, TOTAL_PRODUCTO) VALUES (?,?,?,?)";
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

    public Inventario_Producto ConsultarInventario(int id_product) {
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
    }

}
