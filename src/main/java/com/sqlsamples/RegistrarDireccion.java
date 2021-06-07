
package com.sqlsamples;

public class RegistrarDireccion extends javax.swing.JFrame {

  private static final long serialVersionUID = 1L;

  public RegistrarDireccion() {
    initComponents();
    limpiar_campos();
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        mensaje_informativo = new javax.swing.JLabel();
        boton_registrar = new javax.swing.JButton();
        txt_numero_calle = new javax.swing.JTextField();
        label_nombre = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        txt_municipio = new javax.swing.JTextField();
        txt_colonia = new javax.swing.JTextField();
        label_numero_de_identificacion = new javax.swing.JLabel();
        txt_zona = new javax.swing.JTextField();
        txt_codigo_postal = new javax.swing.JTextField();
        label_numero_de_identificacion1 = new javax.swing.JLabel();
        label_numero_de_identificacion2 = new javax.swing.JLabel();
        label_numero_de_identificacion3 = new javax.swing.JLabel();
        txt_departamento = new javax.swing.JTextField();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de miembros");
        getContentPane().setLayout(null);

        mensaje_informativo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mensaje_informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje_informativo.setText("Registro de Direccion de miembros");
        getContentPane().add(mensaje_informativo);
        mensaje_informativo.setBounds(100, 20, 280, 28);

        boton_registrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        boton_registrar.setText("Registrar");
        getContentPane().add(boton_registrar);
        boton_registrar.setBounds(290, 310, 128, 40);

        txt_numero_calle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_numero_calle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numero_calleKeyTyped(evt);
            }
        });
        getContentPane().add(txt_numero_calle);
        txt_numero_calle.setBounds(170, 70, 250, 28);

        label_nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_nombre.setText("Numero de calle");
        getContentPane().add(label_nombre);
        label_nombre.setBounds(10, 70, 140, 28);

        label_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_email.setText("Municipio");
        getContentPane().add(label_email);
        label_email.setBounds(10, 230, 140, 28);

        txt_municipio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_municipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_municipioKeyTyped(evt);
            }
        });
        getContentPane().add(txt_municipio);
        txt_municipio.setBounds(170, 230, 250, 28);

        txt_colonia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_colonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_coloniaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_colonia);
        txt_colonia.setBounds(170, 110, 250, 28);

        label_numero_de_identificacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion.setText("Barrio_Colonia");
        getContentPane().add(label_numero_de_identificacion);
        label_numero_de_identificacion.setBounds(10, 110, 140, 28);

        txt_zona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_zona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_zonaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_zona);
        txt_zona.setBounds(170, 150, 250, 28);

        txt_codigo_postal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_codigo_postal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigo_postalKeyTyped(evt);
            }
        });
        getContentPane().add(txt_codigo_postal);
        txt_codigo_postal.setBounds(170, 190, 250, 28);

        label_numero_de_identificacion1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion1.setText("Departamento");
        getContentPane().add(label_numero_de_identificacion1);
        label_numero_de_identificacion1.setBounds(10, 270, 140, 28);

        label_numero_de_identificacion2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion2.setText("Zona");
        getContentPane().add(label_numero_de_identificacion2);
        label_numero_de_identificacion2.setBounds(10, 150, 140, 28);

        label_numero_de_identificacion3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_numero_de_identificacion3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_numero_de_identificacion3.setText("Codigo Postal");
        getContentPane().add(label_numero_de_identificacion3);
        label_numero_de_identificacion3.setBounds(10, 190, 140, 28);

        txt_departamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_departamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_departamentoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_departamento);
        txt_departamento.setBounds(170, 270, 250, 28);

        setSize(new java.awt.Dimension(431, 392));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_numero_calleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numero_calleKeyTyped
        // TODO add your handling code here:
        if( Character.isDigit(evt.getKeyChar()) ){
            // acepto
            if( this.txt_numero_calle.getText().length() <= 3 ){
            // acepto    
            }else{
                evt.consume();
            }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_numero_calleKeyTyped

    private void txt_coloniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_coloniaKeyTyped
        // TODO add your handling code here:
        if( Character.isLetter(evt.getKeyChar()) ){
            // acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_coloniaKeyTyped

    private void txt_zonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_zonaKeyTyped
        // TODO add your handling code here:
        if( Character.isDigit(evt.getKeyChar()) ){
            // acepto
            if( this.txt_zona.getText().length() <= 1 ){
            // acepto    
            }else{
                evt.consume();
            }
            
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_zonaKeyTyped

    private void txt_codigo_postalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_postalKeyTyped
        // TODO add your handling code here:
        if( Character.isDigit(evt.getKeyChar()) ){
            // acepto
            if( this.txt_codigo_postal.getText().length() <= 4 ){
            // acepto    
            }else{
                evt.consume();
            }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_codigo_postalKeyTyped

    private void txt_municipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_municipioKeyTyped
        // TODO add your handling code here:
        if( Character.isLetter(evt.getKeyChar()) ){
            // acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_municipioKeyTyped

    private void txt_departamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_departamentoKeyTyped
        // TODO add your handling code here:
        if( Character.isLetter(evt.getKeyChar()) ){
            // acepto
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txt_departamentoKeyTyped

public void limpiar_campos() {
    this.txt_numero_calle.setText("");
    this.txt_colonia.setText("");
    this.txt_zona.setText("");
    this.txt_codigo_postal.setText("");
    this.txt_municipio.setText("");
    this.txt_departamento.setText("");
}

public boolean validar_campos() {
return this.txt_numero_calle.getText().length() > 0 && this.txt_colonia.getText().length() > 0 && this.txt_zona.getText().length() > 0 && this.txt_codigo_postal.getText().length() > 0 && this.txt_municipio.getText().length() > 0 && this.txt_departamento.getText().length() > 0 ;
}

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
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegistrarDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
		
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>
//</editor-fold>

    java.awt.EventQueue.invokeLater(() -> {
			new RegistrarDireccion().setVisible(true);
		});
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_registrar;
    private javax.swing.JButton jButton2;
    public javax.swing.JLabel label_email;
    public javax.swing.JLabel label_nombre;
    public javax.swing.JLabel label_numero_de_identificacion;
    public javax.swing.JLabel label_numero_de_identificacion1;
    public javax.swing.JLabel label_numero_de_identificacion2;
    public javax.swing.JLabel label_numero_de_identificacion3;
    public javax.swing.JLabel mensaje_informativo;
    public javax.swing.JTextField txt_codigo_postal;
    public javax.swing.JTextField txt_colonia;
    public javax.swing.JTextField txt_departamento;
    public javax.swing.JTextField txt_municipio;
    public javax.swing.JTextField txt_numero_calle;
    public javax.swing.JTextField txt_zona;
    // End of variables declaration//GEN-END:variables

}


