
package com.sqlsamples;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Login extends javax.swing.JDialog implements KeyListener {

    private static final long serialVersionUID = 1L;

public Login(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	initComponents();
        limpiar_campos();
}

public void limpiar_campos(){
    this.setSize(168, 296);
    this.txt_password.setEchoChar('*');
    this.txt_password.setText("");
    this.txt_usuario.setText("");
    this.label_usuario.setText("User");
    this.label_password.setText("Password");
}

public boolean validar_campos(){
    return ( (this.txt_password.getPassword().length > 0) && (this.txt_usuario.getText().length() > 0)) ;
}

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_usuario = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        label_password = new javax.swing.JLabel();
        label_usuario = new javax.swing.JLabel();
        boton_registrarme = new javax.swing.JButton();
        boton_iniciar_sesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com.sqlsamples.Bundle"); // NOI18N
        setTitle(bundle.getString("Login.title")); // NOI18N
        setResizable(false);

        txt_usuario.setName("txt_usuario"); // NOI18N
        txt_usuario.setText(bundle.getString("Login.txt_usuario.text")); // NOI18N
        txt_usuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_usuario.setToolTipText(bundle.getString("Login.txt_usuario.toolTipText")); // NOI18N
        txt_usuario.addKeyListener(this);

        txt_password.setName("txt_password"); // NOI18N
        txt_password.setText(bundle.getString("Login.txt_password.text")); // NOI18N
        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_password.setToolTipText(bundle.getString("Login.txt_password.toolTipText")); // NOI18N

        label_password.setName("label_password"); // NOI18N
        label_password.setText(bundle.getString("Login.label_password.text")); // NOI18N
        label_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        label_usuario.setName(bundle.getString("Login.label_usuario.text")); // NOI18N
        label_usuario.setText(bundle.getString("Login.text")); // NOI18N
        label_usuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        boton_registrarme.setName("boton_registrarme"); // NOI18N
        boton_registrarme.setText(bundle.getString("Login.boton_registrarme.text")); // NOI18N
        boton_registrarme.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        boton_iniciar_sesion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        boton_iniciar_sesion.setText(bundle.getString("Login.boton_iniciar_sesion.text")); // NOI18N
        boton_iniciar_sesion.setName("boton_iniciar_sesion"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boton_iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_password, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(boton_registrarme, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_registrarme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }

    // Code for dispatching events from components to event handlers.
// </editor-fold>//GEN-END:initComponents

    public void keyPressed(java.awt.event.KeyEvent evt) {
    }

    public void keyReleased(java.awt.event.KeyEvent evt) {
    }

    public void keyTyped(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == txt_usuario) {
            Login.this.txt_usuarioKeyTyped(evt);
        }
    }

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {                                     
        if( Character.isLetter(evt.getKeyChar()) || evt.getKeyChar() == ' '){
            //acepto
        }else{
            evt.consume();
        }
    }


public static void main(String args[]) {
	
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	
	try {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
		java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
        //</editor-fold>
        
	//</editor-fold>

	java.awt.EventQueue.invokeLater(() -> {
            Login dialog = new Login(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_iniciar_sesion;
    public javax.swing.JButton boton_registrarme;
    public javax.swing.JLabel label_password;
    public javax.swing.JLabel label_usuario;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}


