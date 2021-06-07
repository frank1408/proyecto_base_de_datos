
//package images;
package com.sqlsamples;

import java.awt.Image;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Imagen_a_icono_escalado {

  public Icon icono_escalado_interno;



  public Imagen_a_icono_escalado(String ruta_a_foto, int xwidth, int yheight) {
    try {
      ImageIcon temp = new ImageIcon(ruta_a_foto);
      ImageIcon icono_escalado = new ImageIcon(temp.getImage().getScaledInstance(xwidth, yheight, Image.SCALE_SMOOTH));
      this.icono_escalado_interno = icono_escalado;
    } catch (Exception e) {
      String error = "\n" + e.toString();
      System.out.println(error);
      JOptionPane.showMessageDialog(null, error, "", JOptionPane.PLAIN_MESSAGE);
    }
  }



  public Icon getIcono_escalado_interno() {
    return icono_escalado_interno;
  }

}


