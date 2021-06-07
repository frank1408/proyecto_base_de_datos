
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



public class ConsultasMiembro {
private String host;
private String puerto;
    public ConsultasMiembro(String host, String puerto){
	    this.host = host;
	    this.puerto = puerto;
    }

  public boolean insertar_miembro(Miembro fulanito) {
    boolean insertado = false;
    ConexionSQLServer con = new ConexionSQLServer(this.host,this.puerto, "sa", "test$$S8");
    con.conectar();

//    String sql = "INSERT INTO DBPRUEBA.dbo.miembro (nombre,password,no_identificacion,telefono,fecha_nacimiento,email,genero) VALUES(?,?,?,?,?,?,?)";
    String sql = "INSERT INTO umg.dbo.miembro (miembro_nom,contrasenha,no_identificacion,miembro_tel,fecha_nacimiento,miembro_email,genero,numero_casa) VALUES(?,?,?,?,?,?,?,?)";

    try {

      PreparedStatement ps = con.un_socket.prepareStatement(sql);
      ps.setString(1, fulanito.getNombre());
      ps.setString(2, fulanito.getPassword());
      ps.setInt(3, fulanito.getNumero_de_identificacion());
      ps.setInt(4, fulanito.getTelefono());
      ps.setString(5, fulanito.getFecha_de_nacimiento());
//    ps.setDate(5, fulanito.getFecha_de_nacimiento());
      ps.setString(6, fulanito.getEmail());
      ps.setString(7, fulanito.getGenero());
      ps.setInt(8, fulanito.getNumero_de_casa());

      ps.executeUpdate();
      insertado = true;
    } catch (SQLException ex) {
      System.err.println("\n"+ex.toString());
        JOptionPane.showMessageDialog(null, "No se pudo registrar miembro.", "System info", JOptionPane.PLAIN_MESSAGE);
      

    }
    return insertado;
  }



  public boolean verificar_miembro(Miembro fulanito) {
    boolean usuario_existe = false;
    // usuario, password
    ConexionSQLServer con = new ConexionSQLServer(this.host,this.puerto, "sa", "test$$S8");
    con.conectar();

//    String sql = "select id from DBPRUEBA.dbo.miembro where nombre=? and password=?;";
    String sql = "select id from umg.dbo.miembro where nombre=? and contrasenha=?;";


    try {
      PreparedStatement ps = con.un_socket.prepareStatement(sql);

      ps.setString(1, fulanito.getNombre());
      ps.setString(2, fulanito.getPassword());

      ps.execute();
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        fulanito.setMiembro_id(rs.getInt(1));
        usuario_existe = true;
      }

    } catch (SQLException ex) {
        
      System.err.println("\n"+ex.toString());     
      JOptionPane.showMessageDialog(null,"Nombre o Password incorrectos.", "System info", JOptionPane.PLAIN_MESSAGE);
    }
    return usuario_existe;
  }

}


