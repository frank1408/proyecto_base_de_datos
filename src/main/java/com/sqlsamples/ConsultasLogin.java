
//package modelo;
package com.sqlsamples;

//import com.sqlsamples.controlador.ConexionSQLServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasLogin {
   private String host;
   private String puerto; 
    public ConsultasLogin(String host, String puerto){
	    this.host = host;
	    this.puerto = puerto;
    }
    
  public boolean consultar_login(LoginUser modelo_login) {
    boolean usuario_existe = false;
    // usuario, password
    ConexionSQLServer con = new ConexionSQLServer(this.host,this.puerto, "sa", "test$$S8");
    con.conectar();
														//   DATABASE.dbo.TABLA
    String sql = "select miembro_id from umg.dbo.miembro where miembro_nom=? and contrasenha=?;";

    try {
      PreparedStatement ps = con.un_socket.prepareStatement(sql);

      ps.setString(1, modelo_login.getNombre_de_usuario());
      ps.setString(2, modelo_login.getPassword_de_usuario());

      ps.execute();
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        modelo_login.setMiembro_id(rs.getInt(1));
        usuario_existe = true;
      }

    } catch (SQLException ex) {
      System.err.println(ex.toString());
      JOptionPane.showMessageDialog(null, "\nnombre de usuario o password incorrectos","System info", JOptionPane.PLAIN_MESSAGE);
    }
    return usuario_existe;
  }

}
