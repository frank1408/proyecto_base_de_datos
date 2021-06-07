
package com.sqlsamples;

import java.awt.event.ActionListener;

public class TablaDatos extends javax.swing.JDialog {

private static final long serialVersionUID = 1L;

public TablaDatos(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	initComponents();
}

@SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_resultados = new javax.swing.JTable();
        panel_botones = new javax.swing.JPanel();
        opciones_queries = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("TablaDatos.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabla_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "numero_casa", "numero_calle", "barrio_colonia", "zona", "codigo_postal", "municipio", "departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_resultados.setColumnSelectionAllowed(true);
        tabla_resultados.setName("tabla_resultados"); // NOI18N
        jScrollPane1.setViewportView(tabla_resultados);
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("com/sqlsamples/Bundle"); // NOI18N
        tabla_resultados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabla_resultados.getColumnModel().getColumnCount() > 0) {
            tabla_resultados.getColumnModel().getColumn(0).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title0")); // NOI18N
            tabla_resultados.getColumnModel().getColumn(1).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title1")); // NOI18N
            tabla_resultados.getColumnModel().getColumn(2).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title2")); // NOI18N
            tabla_resultados.getColumnModel().getColumn(3).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title3")); // NOI18N
            tabla_resultados.getColumnModel().getColumn(4).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title4")); // NOI18N
            tabla_resultados.getColumnModel().getColumn(5).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title5")); // NOI18N
            tabla_resultados.getColumnModel().getColumn(6).setHeaderValue(bundle1.getString("TablaDatos.tabla_resultados.columnModel.title6")); // NOI18N
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel_botones.setName("panel_botones"); // NOI18N
        panel_botones.setLayout(new java.awt.BorderLayout());

        opciones_queries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Direccion de miembros", "Join 1", "Join 2" }));
        opciones_queries.setName("opciones_queries"); // NOI18N
        panel_botones.add(opciones_queries, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_botones, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(600, 328));
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

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
		java.util.logging.Logger.getLogger(TablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	
	//</editor-fold>

	java.awt.EventQueue.invokeLater(() -> {
		TablaDatos dialog = new TablaDatos(new javax.swing.JFrame(), true);
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
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> opciones_queries;
    public javax.swing.JPanel panel_botones;
    public javax.swing.JTable tabla_resultados;
    // End of variables declaration//GEN-END:variables
}


