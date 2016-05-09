/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyecto.Modelos.Usuario;
import proyecto.Vista.JFLogin;



public class CtrLogin implements ActionListener{
    
  JFLogin  vistaLogin;
  Usuario login;
  CtrPrincipal principal;
  public boolean logueado;
    
   
  
  public CtrLogin(){
  
    vistaLogin = new JFLogin();
     
    vistaLogin.setVisible(true);
    this.vistaLogin.btnLogin.addActionListener(this);
    this.logueado=false;
    
  }

    @Override
    public void actionPerformed(ActionEvent e) {
     
      if(e.getActionCommand()=="Logear")  
      {
       login = new Usuario();
       
            
        
       
       if(login.login( this.vistaLogin.textUser.getText(),this.vistaLogin.textPassword.getText())){
           
         
           principal = new CtrPrincipal();
           vistaLogin.setVisible(false);
           
           
           
       }else{
       
           JOptionPane.showMessageDialog(this.vistaLogin, "No coinciden los datos");
       
       }
           
       
       
      
      }
       
        
        
        
    }
    
}
