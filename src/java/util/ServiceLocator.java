package util;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServiceLocator {

    /**
     * Instancia del ServiceLocator
     */
    private static ServiceLocator instance = null;

    /**
     * Conexion compartida a la Base de Datos
     */
    private Connection conexion = null;
    public static String classfor="oracle.jdbc.driver.OracleDriver";

    public static String URLBD = "jdbc:oracle:thin:@localhost:1521:XE";
//Nos tocaria crear un rol basico con permiso de coenctar y consltar en la tabla de cliente
    public static  String usuario ;

    public static  String contrasena ;
    
 
    /**
     * Bandera que indica el estado de la conexion
     */
    private boolean conexionLibre = true;

    /**
     * @return instancia del ServiceLocator para el manejo de la conexion
     */
    public static ServiceLocator getInstance() {
        if (instance == null) {
            try {
                instance = new ServiceLocator(usuario,contrasena);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    /**
     * @throws Exception dice si no se pudo crear la conexion
     */
    private ServiceLocator(String user,String contra) throws Exception {
         System.out.println("entro");
            System.out.println(usuario);
            System.out.println(contrasena);
        try {
            //usuario = JOptionPane.showInputDialog("Usuario: ");
            //contrasena = JOptionPane.showInputDialog("Contraseña: ");
            Class.forName(classfor);
            System.out.println("util.ServiceLocator.<init>()"+usuario+" "+ contrasena);
            System.out.println("util.ServiceLocator.<init>( ) el user y la contra"+user + " contra "+ contra);
            conexion = DriverManager.getConnection(URLBD, user, contra);
            conexion.setAutoCommit(false);
            System.out.println("util.ServiceLocator.<init>()"+" que vergaaaaaaa");
        } catch (SQLException e) {
            System.out.println("util.ServiceLocator.<init>() en el catthc "+e.getMessage());
           // throw new RHException("ServiceLocator", "ERROR_CONEXION_BD " + e);
             
           
            
        }
    }

    /**
     * Toma la conexion para que ningun otro proceso la puedan utilizar
     *
     * @return da la conexion a la base de datos
     */
    public synchronized Connection tomarConexion(String usu, String cont) {
        //Porsisal mal hice esto
       
        
        while (!conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }

    /**
     * Libera la conexion de la bases de datos para que ningun otro proceso la
     * pueda utilizar
     */
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }

    /**
     * Cierra la conexion a la base de datos cuando se termina de ejecutar el
     * programa
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza cuando el procedimiento de insercion es terminado
     * correctamente y se asegura que los datos en el modelo estan bien
     * relacionados.
     */
    public void commit() {
        try {
            conexion.commit();
            System.out.println("CAMBIO GUARDADO");
        } catch (SQLException e) {
            System.out.println("ERROR CAMBIO: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deshace los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza por lo general cuando se devuelve una Exepcion. Los
     * procedimientos intermedios no deberia quedar almacenados en la base de
     * datos.
     */
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CambioRol(String usu,String cont) {
        usuario=usu;
        contrasena=cont;
         if (instance == null) {
            try {
                instance = new ServiceLocator(usu,cont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       
        
       
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void MatarConexion(){
    if(instance!=null){
        instance=null;}
    }
    

}
