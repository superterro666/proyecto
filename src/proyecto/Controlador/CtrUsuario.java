/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Controlador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyecto.Modelos.Usuario;
import proyecto.Vista.IFUsuario;
import proyecto.Vista.JFPrincipal;


/**
 *
 * @author terro
 */
public class CtrUsuario implements ActionListener{
   
    
    IFUsuario IFusuario;
    Usuario createUser;
    
    
    
    public CtrUsuario(JFPrincipal Jprincipal){
    
        IFusuario = new IFUsuario(Jprincipal);
        Jprincipal.getContentPane().add(IFusuario);
      
        IFusuario.setVisible(true);
        
        IFusuario.btnCrearUser.addActionListener(this);
       
      
       
        
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Crear"))   {
            createUser = new Usuario();

            String nombre = IFusuario.FieldNombre1.getText();
            String apellidos = IFusuario.FieldApellidos1.getText();
            String direccion = IFusuario.FieldDireccion.getText();
            String telefono = IFusuario.FieldTelefono2.getText();
            String email = IFusuario.FieldEmail.getText();
            String password = IFusuario.Fieldpassword.getText();

            if(!nombre.equals("") && !apellidos.equals("") && !direccion.equals("") && !telefono.equals("") && !email.equals("") && !password.equals("")){

                createUser.crearUser(nombre,apellidos,direccion,telefono,email,password);
            }else{
               JOptionPane.showMessageDialog(IFusuario, " El formulario no esta completo");
            }

         
            
        }  
                
        
    }
    
}
