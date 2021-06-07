
//package modelo;
package com.sqlsamples;

// miembro de biblioteca
//import java.sql.Date;

public class Miembro {

  private int miembro_id;

  private String nombre;

  private int numero_de_identificacion;

  private int telefono;

  //  y si usamos String, o como convertir fecha DD/MM/YYYY a long para un Date(x * 1000 );
//  private Date fecha_de_nacimiento;
  private String fecha_de_nacimiento;

  private String email;

  private String genero;

  private String password;

  private int numero_de_casa; // FK
  
  
  public Miembro(){
      
      miembro_id=-1;

      nombre="";

      numero_de_identificacion=-1;

      telefono=-1;

      fecha_de_nacimiento="";

      email="";

  genero="";

  password="";

  numero_de_casa=-1; // FK
  }
  



  //public Date getFecha_de_nacimiento() {
public String getFecha_de_nacimiento() {
    return fecha_de_nacimiento;
  }



//  public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
  public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
    this.fecha_de_nacimiento = fecha_de_nacimiento;
  }



  public int getNumero_de_identificacion() {
    return numero_de_identificacion;
  }



  public void setNumero_de_identificacion(int numero_de_identificacion) {
    this.numero_de_identificacion = numero_de_identificacion;
  }



  public int getTelefono() {
    return telefono;
  }



  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }





  public int getMiembro_id() {
    return miembro_id;
  }



  public void setMiembro_id(int id) {
    this.miembro_id = id;
  }



  public String getGenero() {
    return genero;
  }



  public void setGenero(String genero) {
    this.genero = genero;
  }



  public String getPassword() {
    return password;
  }



  public void setPassword(String password) {
    this.password = password;
  }



  public String getNombre() {
    return nombre;
  }



  public void setNombre(String nombre) {
    this.nombre = nombre;
  }



  public String getEmail() {
    return email;
  }



  public void setEmail(String email) {
    this.email = email;
  }



  public int getNumero_de_casa() {
    return numero_de_casa;
  }



  public void setNumero_de_casa(int numero_de_casa) {
    this.numero_de_casa = numero_de_casa;
  }

}


