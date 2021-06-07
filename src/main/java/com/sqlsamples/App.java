package com.sqlsamples;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import org.xml.sax.Attributes;

public class App {
public static void main(String[] args) {
	Login login = new Login(null, false);
	LoginUser loginUser = new LoginUser("","");
	TablaDatos vista_datos = new TablaDatos(null,false);                                                              
	RegistrarMiembro regM = new RegistrarMiembro();                                                                   
	RegistrarDireccion regD = new RegistrarDireccion();
	Miembro modelo_miembro = new Miembro();
	Direccion modelo_direccion = new Direccion();
	Controlador control = new Controlador(login, regM, regD, vista_datos,modelo_miembro, modelo_direccion, loginUser);
	control.init("192.168.1.12","1433");//host, puerto
	// sqlserver es el nombre del contenedor con SQLServer
	System.out.println("\n"+ hash.sha256("Franklin Rodriguez 9941 18 5695")+"\n" );
	System.out.println("\nFranklin Rodriguez 9941 18 5695\n" );
	System.out.println("\n"+ hash.sha256("Franklin Rodriguez 9941 18 5695")+"\n" );
} //main
} //App
