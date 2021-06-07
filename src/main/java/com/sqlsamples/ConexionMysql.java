//package controlador;
package com.sqlsamples;

//import crud.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionMysql {

public Connection un_socket = null;

private final String URL;

public ConexionMysql(final String host, final String puerto) {
this.URL = "jdbc:mysql://" + host + ":" + puerto;
}

public Boolean conectar(final String mysql_user, final String mysql_password) {
Boolean status_de_conexion = false;
try {

Class.forName("com.mysql.cj.jdbc.Driver"); // driver actual Mayo 22 2021 21:26
this.un_socket = DriverManager.getConnection(this.URL, mysql_user, mysql_password);

status_de_conexion = true;

} catch (ClassNotFoundException | SQLException e) {

String error = "Error al conectar con MySQL." + "\n" + e.toString();
System.err.println(error);
JOptionPane.showMessageDialog(null, error, "Conexion fallida", JOptionPane.PLAIN_MESSAGE);

} // catch

return status_de_conexion;

} // getConexion

public static void prueba_de_conexion_mysql() {
final String host = "localhost"; // ip / hostname
final String puerto = "3306"; // puerto del servidor mysqlserver
final String sqluser = "root";
final String sqlpassword = "test$$S8";
ConexionMysql prueba = new ConexionMysql(host, puerto);
prueba.conectar(sqluser, sqlpassword);
try {
PreparedStatement ps = prueba.un_socket.prepareStatement("select nombre from pruebas.producto where id =1;");
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

} // class ConexionMysql

