
package com.sqlsamples;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class RegistrarMiembro extends javax.swing.JFrame {

private static final long serialVersionUID = 1L;

public RegistrarMiembro() {
    initComponents();
    limpiar_campos();
  }

public void limpiar_campos() {
    txt_nombre.setText("");
    txt_no_id.setText("");
    txt_telefono.setText("");
    txt_fecha_nacimiento.setText("MM/DD/YYYY");
    txt_correo.setText("");
    sexoMasculino.setSelected(false);sexoFemenino.setSelected(false);
    txt_password.setText("");
    txt_password_confirmacion.setText("");
}

public boolean validar_campos() {
    boolean campos_validos = false;
    if (Arrays.toString(this.txt_password.getPassword()).equals(Arrays.toString(this.txt_password_confirmacion.getPassword()))) {
      // password escrito igual 2 veces
      if (Arrays.toString(this.txt_password.getPassword()).isEmpty() == true) {
      // ambos password son null
        JOptionPane.showMessageDialog(this, "Debes ingresar la misma clave dos veces.");
      } else {
        // valirdar largo
        // validar uso de caracteres raros
        // validar mayusculas y minusculas
        campos_validos = true;
      }
    }
    return campos_validos && (this.sexoMasculino.isSelected() || this.sexoFemenino.isSelected());
}

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo_del_miembro = new javax.swing.ButtonGroup();
        mensaje_informativo = new javax.swing.JLabel();
        boton_registrar = new javax.swing.JButton();
        label_password = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        label_password_confirmacion = new javax.swing.JLabel();
        txt_password_confirmacion = new javax.swing.JPasswordField();
        label_nombre = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_no_id = new javax.swing.JTextField();
        label_numero_de_identificacion = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_fecha_nacimiento = new javax.swing.JTextField();
        label_numero_de_identificacion1 = new javax.swing.JLabel();
        label_numero_de_identificacion2 = new javax.swing.JLabel();
        label_numero_de_identificacion3 = new javax.swing.JLabel();
        sexoMasculino = new javax.swing.JRadioButton();
        sexoFemenino = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de miembros");
        setResizable(false);
        getContentPane().setLayout(null);

        mensaje_informativo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mensaje_informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje_informativo.setText("Registro de miembros");
        getContentPane().add(mensaje_informativo);
        mensaje_informativo.setBounds(200, 20, 210, 28);

        boton_registrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        boton_registrar.setText("Registrar");
        getContentPane().add(boton_registrar);
        boton_registrar.setBounds(450, 400, 128, 40);

        label_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_password.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_password.setText("Contraseña");
        getContentPane().add(label_password);
        label_password.setBounds(10, 310, 210, 28);

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre);
        txt_nombre.setBounds(230, 70, 350, 28);

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txt_password);
        txt_password.setBounds(230, 310, 350, 28);

        label_password_confirmacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_password_confirmacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_password_confirmacion.setText("Confirmar contraseña");
        getContentPane().add(label_password_confirmacion);
        label_password_confirmacion.setBounds(10, 350, 210, 28);

        txt_password_confirmacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_password_confirmacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txt_password_confirmacion);
        txt_password_confirmacion.setBounds(230, 350, 350, 28);

        label_nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_nombre.setText("Nombre");
        getContentPane().add(label_nombre);
        label_nombre.setBounds(10, 70, 210, 28);

        label_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_email.setText("Correo");
        getContentPane().add(label_email);
        label_email.setBounds(10, 230, 210, 28);

        txt_correo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_correo);
        txt_correo.setBounds(230, 230, 350, 28);

        txt_no_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_no_id.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_no_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_no_idKeyTyped(evt);
            }
        });
        getContentPane().add(txt_no_id);
        txt_no_id.setBounds(230, 110, 350, 28);

        label_numero_de_identificacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion.setText("Numero Identificación");
        getContentPane().add(label_numero_de_identificacion);
        label_numero_de_identificacion.setBounds(10, 110, 210, 28);

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono);
        txt_telefono.setBounds(230, 150, 350, 28);

        txt_fecha_nacimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_fecha_nacimiento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_fecha_nacimiento.setText("MM/DD/YYYY");
        txt_fecha_nacimiento.setToolTipText("MM/DD/YYYY");
        txt_fecha_nacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fecha_nacimientoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_fecha_nacimiento);
        txt_fecha_nacimiento.setBounds(230, 190, 350, 28);

        label_numero_de_identificacion1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion1.setText("Sexo");
        getContentPane().add(label_numero_de_identificacion1);
        label_numero_de_identificacion1.setBounds(10, 270, 210, 28);

        label_numero_de_identificacion2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion2.setText("Telefono");
        getContentPane().add(label_numero_de_identificacion2);
        label_numero_de_identificacion2.setBounds(10, 150, 210, 28);

        label_numero_de_identificacion3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion3.setText("Fecha Nacimiento");
        getContentPane().add(label_numero_de_identificacion3);
        label_numero_de_identificacion3.setBounds(20, 190, 210, 28);

        sexo_del_miembro.add(sexoMasculino);
        sexoMasculino.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sexoMasculino.setText("Masculino");
        getContentPane().add(sexoMasculino);
        sexoMasculino.setBounds(240, 270, 108, 26);

        sexo_del_miembro.add(sexoFemenino);
        sexoFemenino.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sexoFemenino.setText("Femenino");
        getContentPane().add(sexoFemenino);
        sexoFemenino.setBounds(370, 270, 104, 26);

        setSize(new java.awt.Dimension(589, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if( Character.isLetter(evt.getKeyChar())  || evt.getKeyChar() == ' ' ){
            //acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_no_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_idKeyTyped
        if( Character.isDigit( evt.getKeyChar() ) ){
            //acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_no_idKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        if( Character.isDigit( evt.getKeyChar() ) ){
            //acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_fecha_nacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_nacimientoKeyTyped
        if( Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '/' ){
            //acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_fecha_nacimientoKeyTyped

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        if( Character.isDigit(evt.getKeyChar()) || Character.isLetter(evt.getKeyChar()) || evt.getKeyChar() == '_'  || evt.getKeyChar() == '.' || evt.getKeyChar() == '@' ){
            //acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_correoKeyTyped

  public static void main(String args[]) {

//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
/*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(RegistrarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RegistrarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RegistrarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegistrarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>

    java.awt.EventQueue.invokeLater(() -> {
      new RegistrarMiembro().setVisible(true);
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_registrar;
    public javax.swing.JLabel label_email;
    public javax.swing.JLabel label_nombre;
    public javax.swing.JLabel label_numero_de_identificacion;
    public javax.swing.JLabel label_numero_de_identificacion1;
    public javax.swing.JLabel label_numero_de_identificacion2;
    public javax.swing.JLabel label_numero_de_identificacion3;
    public javax.swing.JLabel label_password;
    public javax.swing.JLabel label_password_confirmacion;
    public javax.swing.JLabel mensaje_informativo;
    public javax.swing.JRadioButton sexoFemenino;
    public javax.swing.JRadioButton sexoMasculino;
    private javax.swing.ButtonGroup sexo_del_miembro;
    public javax.swing.JTextField txt_correo;
    public javax.swing.JTextField txt_fecha_nacimiento;
    public javax.swing.JTextField txt_no_id;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JPasswordField txt_password_confirmacion;
    public javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}


