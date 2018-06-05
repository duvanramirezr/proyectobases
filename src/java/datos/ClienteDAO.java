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
    private  String user="";
    private String contra;
    private String adminuser = "ADMINSISTEMA";
    private String admincontra = "ADMINSISTEMA";
     public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

     
    public void setContra(String contra) {
        this.contra = contra;
    }
    public Cliente consultarCliente(int id_cliente) {
        Cliente c = new Cliente();
        try {
            String strSQL = "SELECT CEDULA_CLIENTE, NOMBRE, APELLIDO, TELEFONO, CONTRASENA FROM CLIENTES WHERE ID_CLIENTE = ?";
           // ServiceLocator.CambioRol(adminuser, admincontra);
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_cliente);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                c.setCedula_cliente(id_cliente);
                c.setNombre(rs.getString("NOMBRE"));
                c.setApellido(rs.getString("APELLIDO"));
                c.setTelefono(rs.getString("TELEFONO"));
                c.setContrasena(rs.getInt("CONTRASENA"));
             

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
    public Cliente consultarIDCliente() {
        Cliente c = new Cliente();
      System.out.println("NOMBRE CLIENTE1: " + ServiceLocator.usuario);
        try {
            System.out.println("NOMBRE CLIENTE2: " + ServiceLocator.usuario);
            String strSQL = "SELECT CEDULA_CLIENTE FROM CLIENTES WHERE NOMBRE = ?";             
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            System.out.println("NOMBRE CLIENTE3: " + ServiceLocator.usuario);
            prepStmt.setString(1,ServiceLocator.usuario);
            
            ResultSet rs = prepStmt.executeQuery();
            //System.out.println("CC: "+rs.getInt("CEDULA_CLIENTE"));
            if (rs.next()) {
                
                c.setCedula_cliente(rs.getInt("CEDULA_CLIENTE"));
                c.setNombre(ServiceLocator.usuario);
                                        
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
    public String autenticacioCli(String nombre,int contraseña) {
        Cliente cl = new Cliente();          
        PreparedStatement pst = null;
        ResultSet rs = null;
        String msjError="1";
        
        try {
            String strSQL = " SELECT * FROM CLIENTES WHERE NOMBRE = ? and CONTRASENA = ?";
             ServiceLocator.CambioRol(nombre, contraseña+"");
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            pst = conexion.prepareStatement(strSQL);
            pst.setString(1,nombre);
            pst.setInt(2, contraseña);
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
            prepStmt.setInt(2, cliente.getCedula_cliente());
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
