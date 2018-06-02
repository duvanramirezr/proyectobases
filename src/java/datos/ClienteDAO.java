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

public class ClienteDAO {
    private String user="";
    private String contra;
     public void setUser(String user) {
        this.user = user;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    public Cliente consultarCliente(int id_cliente) {
        Cliente c = new Cliente();
        try {
            String strSQL = "SELECT ID_CLIENTE, NOMBRE, APELLIDO, TELEFONO, CONTRASENA, ID_REPRESENTANTE FROM NATAME.CLIENTE WHERE ID_CLIENTE = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_cliente);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                c.setId_cliente(id_cliente);
                c.setNombre(rs.getString("NOMBRE"));
                c.setApellido(rs.getString("APELLIDO"));
                c.setTelefono(rs.getString("TELEFONO"));
                c.setContrasena(rs.getInt("CONTRASENA"));
                c.setId_representante(rs.getInt("ID_REPRESENTANTE"));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el cliente");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO CLIENTE: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return c;
    }
    public String autenticacioCli(String nombre,String contraseña) {
        Cliente cl = new Cliente();          
        PreparedStatement pst = null;
        ResultSet rs = null;
        String msjError="";
        
        try {
            String strSQL = " SELECT * FROM CLIENTE WHERE NOMBRE = ? and CONTRASENA = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            pst = conexion.prepareStatement(strSQL);
            pst.setString(1,nombre);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();        
          if(rs.next()){
          cl.setNombre(nombre);
        
          }
                 
        } catch (SQLException e) {
           msjError="Error autem"+e;
        }
        
        finally {
            ServiceLocator.getInstance().liberarConexion();
        }

        
        
    return msjError;
    
    }

    public void actualizarContrasena(Cliente cliente) throws RHException {
        try {
            String strSQL = "UPDATE NATAME.CLIENTE SET CONTRASENA = ? WHERE ID_CLIENTE = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, cliente.getContrasena());
            prepStmt.setInt(2, cliente.getId_cliente());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            throw new RHException("Cliente", "Constraseña NO cambiada" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void calificarRep(Venta_Producto vp) throws RHException {
        try {
            String strSQL = "UPDATE NATAME.VENTA_PRODUCTO SET CALIFICACION = ? WHERE ID_PEDIDO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, vp.getCalificacion());
            prepStmt.setInt(2, vp.getId_pedido());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            throw new RHException("Venta", "Calificacion NO registrada" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
}
