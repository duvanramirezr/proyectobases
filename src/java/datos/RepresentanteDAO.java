package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.swing.JOptionPane;
import negocio.*;
import util.RHException;
import util.ServiceLocator;

public class RepresentanteDAO {
     private String user="";
     private String contra;
     private Statement stm;
     public void setUser(String user) {
        this.user = user;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Representante consultarRepresentante(int id_reprs) {
        Representante r = new Representante();
        try {
            String strSQL = "SELECT ID_REPRESENTANTE, NOMBRE, APELLIDO, TELEFONO, CONTRASENA, ID_REGION, ID_CLASIFICACION FROM NATAME.REPRESENTANTE_VENTA WHERE ID_REPRESENTANTE = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_reprs);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                r.setId_representante(id_reprs);
                r.setNombre(rs.getString("NOMBRE"));
                r.setApellido(rs.getString("APELLIDO"));
                r.setTelefono(rs.getString("TELEFONO"));
                r.setContrasena(rs.getInt("CONTRASENA"));
                r.setId_region(rs.getInt("ID_REGION"));
                r.setId_clasificacion(rs.getInt("ID_CLASIFICACION"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el representante");
            }
          
            //rs.close();
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO REPRESENTANTE: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return r;
    }
       public String autenticacionrep(String nombre,String contraseña) {
        Representante r = new Representante();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try {
            
             String strSQL = " SELECT * FROM REPRESENTANTE_VENTA WHERE NOMBRE = ? and CONTRASENA = ?";
             
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            pst = conexion.prepareStatement(strSQL);
            pst.setString(1, nombre);
            pst.setString(2, contraseña);
            
            rs = pst.executeQuery();
          
                    
          if(rs.next()){
             r.setNombre(nombre);
          return "";
          }
                 
        } catch (Exception e) {
            System.out.println("Error autem"+e);
        }
        
        finally {
            
            ServiceLocator.getInstance().liberarConexion();
        }

        
        
    return "error";
    
    }
        public String crearCliente (Cliente cliente) throws SQLException {
           String msjError="";
            
             try {
            String strSQL= "CREATE USER "+cliente.getNombre()+" IDENTIFIED BY "+cliente.getContrasena()+" DEFAULT TABLESPACE DEFUSUARIO TEMPORARY TABLESPACE TEMUSUARIO";     
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            Statement stm= conexion.createStatement();
            stm.executeUpdate(strSQL);//ExecuteInmediate
            stm.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
             msjError="No pudo crear cliente " + e.getMessage();
             //RHException("Cliente", e.getMessage() + "No se pudo crear el cliente");
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
       return msjError;     
        }
        
    public String registrarCliente(Cliente cliente) throws SQLException { 
        String msj="";
        try {
            String strSQL = "INSERT INTO NATAME.CLIENTE (ID_CLIENTE, NOMBRE, APELLIDO, TELEFONO, CONTRASENA, ID_REPRESENTANTE) VALUES(?,?,?,?,?,?)";
            System.out.println("En Registrar Cliente " + user +" "+contra);
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, cliente.getId_cliente());
            prepStmt.setString(2, cliente.getNombre());
            prepStmt.setString(3, cliente.getApellido());
            prepStmt.setString(4, cliente.getTelefono());
            prepStmt.setInt(5, cliente.getContrasena());
            prepStmt.setInt(6, cliente.getId_representante());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
           //System.out.println(e.getMessage());
            msj=e.getMessage();
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    return msj;
    }

    public void actualizarContrasena(Representante reprs) throws RHException {
        try {
            String strSQL = "UPDATE NATAME.REPRESENTANTE_VENTA SET CONTRASENA = ? WHERE ID_REPRESENTANTE = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion(user,contra);
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, reprs.getContrasena());
            prepStmt.setInt(2, reprs.getId_representante());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            throw new RHException("Representante", "Constraseña NO cambiada" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    private void RHException(String cliente, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
