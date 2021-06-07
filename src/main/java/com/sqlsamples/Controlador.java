package com.sqlsamples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador implements MouseListener, ActionListener {

    private String host;
    private String puerto;

//vista
    private RegistrarMiembro vista_registro_miembro;
    private RegistrarDireccion vista_registro_direccion;
    private Login vista_login;
    private TablaDatos vista_datos;

//modelo
    private Miembro modelo_miembro;
    private Direccion modelo_direccion;
    private LoginUser modelo_login;

//mediador
    private ConsultasMiembro queries_miembro;
    private ConsultasDireccion queries_direccion;
    private ConsultasLogin queries_login;

    public Controlador(Login login, RegistrarMiembro reg_miembro, RegistrarDireccion reg_direccion, TablaDatos vista_datos, Miembro miembro, Direccion direccion, LoginUser loginUser) {
        this.modelo_miembro = miembro;
        this.modelo_direccion = direccion;
        this.modelo_login = loginUser;

        this.vista_registro_miembro = reg_miembro;
        this.vista_registro_direccion = reg_direccion;
        this.vista_login = login;
        this.vista_datos = vista_datos;

        this.vista_login.limpiar_campos();
        this.vista_registro_direccion.limpiar_campos();
        this.vista_registro_miembro.limpiar_campos();

        this.queries_direccion = null;
        this.queries_miembro = null;
        this.queries_login = null;
        this.agregar_listener();
        this.vista_registro_miembro.setLocationRelativeTo(null);
        this.vista_registro_direccion.setLocationRelativeTo(null);
        this.vista_login.setLocationRelativeTo(null);
        this.vista_datos.setLocationRelativeTo(null);

        this.vista_datos.setVisible(false);
        this.vista_registro_direccion.setVisible(false);
        this.vista_registro_miembro.setVisible(false);
        this.vista_login.setVisible(false);

// JDialog  DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE
// JFrame x
        this.vista_login.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.vista_datos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.vista_registro_direccion.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.vista_registro_miembro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void init(String host, String puerto) {
        this.host = host;
        this.puerto = puerto;
        this.vista_login.setVisible(true);
    }

    private void agregar_listener() {
        this.vista_registro_miembro.boton_registrar.addMouseListener(this);
        this.vista_registro_direccion.boton_registrar.addMouseListener(this);
        this.vista_login.boton_registrarme.addMouseListener(this);
        this.vista_login.boton_iniciar_sesion.addMouseListener(this);

        this.vista_datos.opciones_queries.addActionListener(this);

    }

    private void llenar_tabla() {
        ConexionSQLServer con = new ConexionSQLServer(this.host, this.puerto, "sa", "test$$S8");
        con.conectar();

        //DefaultTableModel m_tabla = (DefaultTableModel) this.vista_datos.tabla_resultados.getModel();
        Object[] columnas_tabla_join = new Object[7];
        columnas_tabla_join[0] = "Numero Casa";
        columnas_tabla_join[1] = "Numero Calle";
        columnas_tabla_join[2] = "Barrio o Colonia";
        columnas_tabla_join[3] = "Zona";
        columnas_tabla_join[4] = "Codigo Postal";
        columnas_tabla_join[5] = "Municipio";
        columnas_tabla_join[6] = "Departamento";
        DefaultTableModel m_tabla = new DefaultTableModel(columnas_tabla_join, 0);

        m_tabla.setRowCount(0);
        try {
            String sql = "select numero_casa,numero_calle, barrio_colonia, zona, codigo_postal, municipio, departamento from umg.dbo.direccion_miembro;";
            PreparedStatement ps = con.un_socket.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            Object[] fila_n = new Object[columnas];
            //this.vista_datos.tabla_resultados.setModel(m_tabla);   Agregar Antes o despues???
            while (rs.next()) {

                for (int i = 0; i < columnas; i++) {
                    fila_n[i] = rs.getObject(i + 1);
                }
                m_tabla.addRow(fila_n);
            } // while
            this.vista_datos.tabla_resultados.setModel(m_tabla);// Agregar Antes o despues???
        } catch (SQLException ex) {

            System.err.println("\n" + ex.toString());
            JOptionPane.showMessageDialog(this.vista_datos, "No se recolectaron los datos solicitados", "System info", JOptionPane.PLAIN_MESSAGE);
        } // catch
    } // llenar_tabla

    private void llenar_tabla_join_uno() { // Hace falta realizar pruebas con DB

        ConexionSQLServer con = new ConexionSQLServer(this.host, this.puerto, "sa", "test$$S8");
        con.conectar();
        Object[] columnas_tabla_join = new Object[4];
        columnas_tabla_join[0] = "Nombre Articulo"; // Se relaciona Articulo
        columnas_tabla_join[1] = "Costo Articulo";// con Autor mediante
        columnas_tabla_join[2] = "Nombre Autor";// la tabla Creado
        columnas_tabla_join[3] = "Apellido Autor";
        DefaultTableModel modelo_tabla_join = new DefaultTableModel(columnas_tabla_join, 0);

        modelo_tabla_join.setRowCount(0);
        try {

            String sql = ""
                    + "SELECT Articulo.arti_nombre, Articulo.costo, Autor.autor_nombre, Autor.autor_apellido FROM umg.dbo.Articulo "
                    + " INNER JOIN umg.dbo.Creado ON umg.dbo.Articulo.articulo_id=umg.dbo.Creado.articulo_id "
                    + " INNER JOIN umg.dbo.Autor ON umg.dbo.Autor.autor_id=umg.dbo.Creado.autor_id ;";

            PreparedStatement ps = con.un_socket.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            Object[] fila_n = new Object[columnas];
            while (rs.next()) {

                for (int i = 0; i < columnas; i++) {
                    fila_n[i] = rs.getObject(i + 1);
                }
                modelo_tabla_join.addRow(fila_n);
            } // while
            this.vista_datos.tabla_resultados.setModel(modelo_tabla_join);
        } catch (SQLException ex) {

            System.err.println("\n" + ex.toString());
            JOptionPane.showMessageDialog(this.vista_datos, "No se recolectaron los datos solicitados", "System info", JOptionPane.PLAIN_MESSAGE);
        } // catch
    } // llenar_tabla_join 1

    // insertar tabla segundo join
    private void llenar_tabla_join_dos() { // Hace falta realizar pruebas con DB

        ConexionSQLServer con = new ConexionSQLServer(this.host, this.puerto, "sa", "test$$S8");
        con.conectar();
        Object[] columnas_tabla_join = new Object[4];
        columnas_tabla_join[0] = "Nombre Articulo"; // Se relaciona Articulo
        columnas_tabla_join[1] = "Costo Articulo";// con Miembro mediante
        columnas_tabla_join[2] = "Nombre Miembro";// la tabla Registro
        columnas_tabla_join[3] = "Fecha Alquiler";
        DefaultTableModel modelo_tabla_join = new DefaultTableModel(columnas_tabla_join, 0);

        modelo_tabla_join.setRowCount(0);
        try {

            String sql = ""
                    + "SELECT Articulo.arti_nombre, Articulo.costo, Miembro.miembro_nom, Registro.fecha_alquiler FROM umg.dbo.Articulo "
                    + " INNER JOIN umg.dbo.Registro ON umg.dbo.Registro.articulo_id=umg.dbo.Articulo.articulo_id "
                    + " INNER JOIN umg.dbo.Miembro ON umg.dbo.Miembro.miembro_id=umg.dbo.Registro.miembro_id ;";

            PreparedStatement ps = con.un_socket.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            Object[] fila_n = new Object[columnas];
            while (rs.next()) {

                for (int i = 0; i < columnas; i++) {
                    fila_n[i] = rs.getObject(i + 1);
                }
                modelo_tabla_join.addRow(fila_n);
            } // while
            this.vista_datos.tabla_resultados.setModel(modelo_tabla_join);
        } catch (SQLException ex) {

            System.err.println("\n" + ex.toString());
            JOptionPane.showMessageDialog(this.vista_datos, "No se recolectaron los datos solicitados", "System info", JOptionPane.PLAIN_MESSAGE);
        } // catch
    } // llenar_tabla_join 1    

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.vista_login.boton_iniciar_sesion) {
            if (this.vista_login.validar_campos()) {
                this.modelo_login.setNombre_de_usuario(this.vista_login.txt_usuario.getText());

                char[] clave = this.vista_login.txt_password.getPassword();
                String la_clave = "";
                for (char c : clave) {
                    la_clave += Character.toString(c);
                }
                this.modelo_login.setPassword_de_usuario(la_clave);
                la_clave = "0";
                Arrays.fill(clave, '0');
                this.queries_login = new ConsultasLogin(this.host, this.puerto);
                boolean resultado_login = this.queries_login.consultar_login(this.modelo_login);
                if (resultado_login) {
                    this.vista_login.txt_password.setText(" ");
                    JOptionPane.showMessageDialog(this.vista_login, "Bienvenido " + this.modelo_login.getNombre_de_usuario(), "System info", JOptionPane.PLAIN_MESSAGE);
                    this.vista_login.dispose();
                    this.vista_registro_miembro.dispose();
                    this.vista_registro_direccion.dispose();
                    this.vista_datos.setVisible(true);
                    
                    // this.llenar_tabla(); FUNCIONA
                    // this.llenar_tabla_join_uno(); // REALIZAR PRUEBAS DB; PROBAR
                    // this.llenar_tabla_join_dos(); // IGUAL A uno, falta probar

                } else {
                    JOptionPane.showMessageDialog(this.vista_login, "Credenciales invalidos.", "System info", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this.vista_login, "Debes ingresar un nombre de usuario\n" + "y password que esten previamente \n" + "registrados como miembros.", "System info", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == this.vista_login.boton_registrarme) {
            this.vista_login.setVisible(false);
            this.vista_registro_direccion.setVisible(true);
        }

        if (e.getSource() == this.vista_registro_direccion.boton_registrar) {
            // this.vista_registro_direccion.setVisible(false);
// validar campos que se requieran...
            if (this.vista_registro_direccion.validar_campos()) {
// insertar direccion, traer el id de direccion y pasarlo para registro_miembro
                this.modelo_direccion.setCodigo_postal(Integer.parseInt(this.vista_registro_direccion.txt_codigo_postal.getText()));
                this.modelo_direccion.setColonia(this.vista_registro_direccion.txt_colonia.getText());
                this.modelo_direccion.setDepartamento(this.vista_registro_direccion.txt_departamento.getText());
                this.modelo_direccion.setMunicipio(this.vista_registro_direccion.txt_municipio.getText());
                this.modelo_direccion.setNumero_calle(Integer.parseInt(this.vista_registro_direccion.txt_numero_calle.getText()));
                this.modelo_direccion.setZona(Integer.parseInt(this.vista_registro_direccion.txt_zona.getText()));

                this.queries_direccion = new ConsultasDireccion(this.host, this.puerto);
                boolean resultado_ins_dir = this.queries_direccion.insertar_direccion(this.modelo_direccion);

                if (resultado_ins_dir) {
                    JOptionPane.showMessageDialog(this.vista_registro_direccion, "Direccion del miembro registrada correctamente", "System info", JOptionPane.PLAIN_MESSAGE);
                    this.queries_direccion.consultar_direccion(this.modelo_direccion); // ya tengo el id

                    this.vista_registro_direccion.setVisible(false);
                    this.vista_registro_direccion.dispose();

                    this.vista_registro_miembro.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(this.vista_registro_direccion, "Direccion del miembro no pudo registrarse.", "System info", JOptionPane.PLAIN_MESSAGE);
                    this.vista_registro_direccion.setVisible(true);

                }

            }// campos verificados
            else {
                String info = "Campos invalidos en registro del miembro";
                System.out.println(info);
                JOptionPane.showMessageDialog(this.vista_registro_direccion, info, "System info", JOptionPane.PLAIN_MESSAGE);
                this.vista_registro_direccion.setVisible(true);
            }

        } // click reg dir

        if (e.getSource() == this.vista_registro_miembro.boton_registrar) {

// validar como true todas las comprobaciones
            if (this.vista_registro_miembro.validar_campos()) {
// transmitir datos entre objetos, una vez que ya son validos.
                this.modelo_miembro.setEmail(this.vista_registro_miembro.txt_correo.getText());
                this.modelo_miembro.setFecha_de_nacimiento(this.vista_registro_miembro.txt_fecha_nacimiento.getText());
                this.modelo_miembro.setGenero(this.vista_registro_miembro.sexoMasculino.isSelected() ? "M" : "F");
                this.modelo_miembro.setNombre(this.vista_registro_miembro.txt_nombre.getText());
                this.modelo_miembro.setNumero_de_casa(this.modelo_direccion.getNumero_casa());// Registrar direccion, traer id y ponerlo aqui
                this.modelo_miembro.setNumero_de_identificacion(Integer.parseInt(this.vista_registro_miembro.txt_no_id.getText()));

                char[] clave = this.vista_registro_miembro.txt_password.getPassword();
                String la_clave = "";
                for (char c : clave) {
                    la_clave += Character.toString(c);
                }
                this.modelo_miembro.setPassword(la_clave);
                la_clave = "0";
                Arrays.fill(clave, '0');

                this.modelo_miembro.setTelefono(Integer.parseInt(this.vista_registro_miembro.txt_telefono.getText()));
                this.queries_miembro = new ConsultasMiembro(this.host, this.puerto);
                boolean resultado_ins_miembro = this.queries_miembro.insertar_miembro(this.modelo_miembro);
                if (resultado_ins_miembro) {
                    JOptionPane.showMessageDialog(this.vista_registro_miembro, "Miembro registrado exitosamente", "System info", JOptionPane.PLAIN_MESSAGE);
                    this.vista_registro_miembro.dispose(); //.setVisible(false);
                    this.vista_login.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this.vista_registro_miembro, "Miembro no se pudo registrar", "System info", JOptionPane.PLAIN_MESSAGE);
                    this.vista_registro_miembro.setVisible(true);
                }

            } else {
                String error = "Campos invalidos en registro del miembro";
                System.out.println(error);
                JOptionPane.showMessageDialog(this.vista_registro_miembro, error, "System info", JOptionPane.PLAIN_MESSAGE);
            }

            // vistas, se ve o no se ve
        } // click registrar miembro

    } // mouse click en vistas

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (this.vista_datos.opciones_queries.getSelectedIndex()) {
            case 0:
                this.llenar_tabla();
                break;
            case 1:
                this.llenar_tabla_join_uno();
                break;
            case 2:
                this.llenar_tabla_join_dos();
                break;
            default:
                JOptionPane.showMessageDialog(this.vista_datos, "Selecciona una opcion del menu desplegable", "System info", JOptionPane.PLAIN_MESSAGE);
                break;
        }

    }

}
