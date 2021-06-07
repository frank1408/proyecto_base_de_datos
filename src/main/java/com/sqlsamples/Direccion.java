
//package modelo;
package com.sqlsamples;

public class Direccion {

private int numero_casa;//id
private int numero_calle;
private String colonia;
private int zona;
private int codigo_postal;
private String municipio;
private String departamento;

public Direccion(){
    numero_casa=-1;//id
    numero_calle=-1;
    colonia="";
    zona=-1;
    codigo_postal=-1;
    municipio="";
    departamento="";
}

public void setNumero_casa(int id) {
    this.numero_casa = id;
}

public void setNumero_calle(int numero_calle) {
    this.numero_calle = numero_calle;
}

public void setColonia(String colonia) {
    this.colonia = colonia;
}

  public void setZona(int zona) {
    this.zona = zona;
  }

  public void setCodigo_postal(int codigo_postal) {
    this.codigo_postal = codigo_postal;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }






  public int getNumero_casa() {
    return numero_casa;
  }
  public int getNumero_calle() {
    return numero_calle;
  }

  public String getBarrio_Colonia() {
    return colonia;
  }
  public int getZona() {
    return zona;
  }
  public int getCodigo_postal() {
    return codigo_postal;
  }
  public String getMunicipio() {
    return municipio;
  }
  public String getDepartamento() {
    return departamento;
  }
}
