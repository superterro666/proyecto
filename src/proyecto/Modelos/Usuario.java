/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Modelos;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Usuario {

    Conexion conexion;
    Connection con;

    public Usuario() {

        conexion = new Conexion();
        con = conexion.conectar();

    }
    
    
    
    public boolean crearUser(String nombre,String apellidos,String direccion, String telefono, String email, String password){
    
     String query = "INSERT INTO usuario (nombre,apellidos,direccion,telefono,email,password,role,username,salt)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
     String role = "user";
     String salt = generateHash(String.valueOf(System.currentTimeMillis()));
     String username = email;
     
     try{ 
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString (1, nombre);
      preparedStmt.setString (2, apellidos);
      preparedStmt.setString   (3, direccion);
      preparedStmt.setString(4, telefono);
      preparedStmt.setString   (5, email);
      preparedStmt.setString   (6, generateHash(password));
      preparedStmt.setString(7, role);
      preparedStmt.setString   (8, username);
      preparedStmt.setString   (9,salt);
      
      
 
      // execute the preparedstatement
      preparedStmt.execute();
       
      con.close();
     }catch(SQLException e){
         System.out.println(e);
     } 
        

     
    return false;
    }
    
    
    
    
    
    

    public boolean login(String user, String password) {

        try {

            password = generateHash(password);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement("SELECT id FROM usuario WHERE email='" + user + "' AND password='" + password + "'");
            rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Exito");
                return true;
            }

        } catch (Exception e) {

        }

        return false;
    }

    public String generateHash(String password) {

        MessageDigest md = null;
        byte[] hash = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            hash = md.digest(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return convertToHex(hash);
    }

    private String convertToHex(byte[] raw) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < raw.length; i++) {
            sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
