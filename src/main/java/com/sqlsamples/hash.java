
//package modelo;
package com.sqlsamples;

public class hash {

  private static String getHash(String texto_claro, String tipo_de_hash) {
    try {
      // Se recomienda usar SHA-256, SHA-512
      // Otras opciones son
      //SHA-512, SHA-256, SHA-1, MD5
      java.security.MessageDigest md = java.security.MessageDigest.getInstance(tipo_de_hash);
      
      byte[] array = md.digest(texto_claro.getBytes());
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
      }
      return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public static String sha512(String txt) {
    return hash.getHash(txt, "SHA-512");
  }

  
  public static String sha256(String txt) {
    return hash.getHash(txt, "SHA-256");
  }
  
  public static String md5(String txt) {
    return hash.getHash(txt, "MD5");// no recomendado
  }



  public static String sha1(String txt) {
    return hash.getHash(txt, "SHA-1");// no recomendado
  }
}


