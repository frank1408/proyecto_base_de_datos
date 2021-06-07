
//package modelo;
package com.sqlsamples;

//import com.sqlsamples.controlador.ConexionSQLServer;
//import com.sqlsamples.modelo.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;



public class ConsultasDireccion {
   private String host; 
   private String puerto; 
    public ConsultasDireccion(String host, String puerto){
	    this.host   = host;
	    this.puerto = puerto;
    }

  public boolean insertar_direccion(Direccion direccion) {
    boolean insertado = false;
    ConexionSQLServer con = new ConexionSQLServer(this.host,this.puerto, "sa", "test$$S8");
    con.conectar();

//    String sql = "INSERT INTO DBPRUEBA.dbo.miembro (nombre,password,no_identificacion,telefono,fecha_nacimiento,email,genero) VALUES(?,?,?,?,?,?,?)";
    String sql = "INSERT INTO umg.dbo.direccion_miembro (numero_calle,barrio_colonia,zona,codigo_postal,municipio,departamento) VALUES(?,?,?,?,?,?)";

    try {

      PreparedStatement ps = con.un_socket.prepareStatement(sql);
      ps.setInt(    1, direccion.getNumero_calle());
      ps.setString( 2, direccion.getBarrio_Colonia());
      ps.setInt(    3, direccion.getZona());
      ps.setInt(    4, direccion.getCodigo_postal());
      ps.setString( 5, direccion.getMunicipio());
      ps.setString( 6, direccion.getDepartamento());

      ps.executeUpdate();
      insertado = true;

    } catch (SQLException ex) {
      System.err.println("\n"+ex.toString());
      JOptionPane.showMessageDialog(null, "No se pudo registrar direccion.", "System info", JOptionPane.PLAIN_MESSAGE);
    }
    return insertado;
  }



  public boolean consultar_direccion(Direccion direccion) {
    boolean usuario_existe = false;
    // usuario, password
    ConexionSQLServer con = new ConexionSQLServer(this.host,this.puerto, "sa", "test$$S8");
    con.conectar();
														//   DATABASE.dbo.TABLA
    String sql = "select numero_casa from umg.dbo.direccion_miembro where barrio_colonia=? and numero_calle=?;";

    try {
      PreparedStatement ps = con.un_socket.prepareStatement(sql);

      ps.setString(1, direccion.getBarrio_Colonia());
      ps.setInt(2, direccion.getNumero_calle());

      ps.execute();
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        direccion.setNumero_casa(rs.getInt(1));
        usuario_existe = true;
      }

    } catch (SQLException ex) {
        
      System.err.println("\n" + ex.toString());
      JOptionPane.showMessageDialog(null, "No hay registro direccion que coincida con colonia y numero de calle", "System info", JOptionPane.PLAIN_MESSAGE);

    }
    return usuario_existe;
  }

}


