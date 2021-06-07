
package com.sqlsamples;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionSQLServer {

    public Connection un_socket = null;

    private final String URL;

    public ConexionSQLServer(final String host, final String puerto, final String sql_user, final String sql_password) {
        this.un_socket = null;

        this.URL = "jdbc:sqlserver://" + host + ":" + puerto + ";"
                + "user=" + sql_user + ";"
                + "password=" + sql_password + ";"
                + "loginTimeout=30;";
    }

public Boolean conectar() {
Boolean status_de_conexion = false;
try{
    
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // original microsoft
// $HOME/.m2/repository/com/microsoft/sqlserver/mssql-jdbc/9.2.1.jre8

this.un_socket = DriverManager.getConnection(this.URL);

// Nivel de aislamiento de transacciones
//this.un_socket.setTransactionIsolation( Connection.TRANSACTION_READ_COMMITTED ); // modo default

// esta linea de abajo Snapshot isolation la comente
// debido a que da mucho error debido a que no compila con maven
// directamente. Pero si se hace con el netbeans si funciona correctamente.
// aunque necesito que funcione en docker con maven desde un container
// #en netbeans si funciona en docker no
this.un_socket.setTransactionIsolation(SQLServerConnection.TRANSACTION_SNAPSHOT);// Hay que habilitar este modo Snapshot en DB.
// #en netbeans si funciona en docker no
// Nivel de aislamiento de transacciones

status_de_conexion = true;

//} catch (ClassNotFoundException | SQLException e) {

} catch ( SQLException e) {
String error = "\nError al conectar con SQLServer.\n";
System.err.println(e.getErrorCode()+ "\n"+e.toString());
JOptionPane.showMessageDialog(null, error, "System info", JOptionPane.PLAIN_MESSAGE);

} // catch

return status_de_conexion;

} // conectar

    public static void prueba_de_conexion_sqlserver() {
        final String host = "192.168.1.7"; // mi server gnu/linux
        final String puerto = "1433"; // mi servicio sqlserver con docker / local
        final String sqluser = "sa";
        final String sqlpassword = "test$$S8";
        ConexionSQLServer prueba = new ConexionSQLServer(host, puerto, sqluser, sqlpassword);
        prueba.conectar();
        try {
            PreparedStatement ps = prueba.un_socket.prepareStatement("SELECT nombre FROM pruebas.dbo.persona"); // tabla sencilla previamente creada e insertada con un dato para ver si funciona...
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("nombre")); // nombre es columna de talba persona
            } else {
                System.out.println("No hay resultados de sqlserver db");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

}
