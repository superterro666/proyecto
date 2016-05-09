/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Controlador;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyecto.Vista.JFPrincipal;





public class CtrPrincipal implements ActionListener{
    
 JFPrincipal PFrame; 
 CtrUsuario CUsuario;


 
 
public CtrPrincipal(){

   PFrame = new JFPrincipal();
   PFrame.setExtendedState(PFrame.MAXIMIZED_BOTH);
   PFrame.setVisible(true);
   PFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
   
  
  
   
  
   
  
  
   
   
  
   this.PFrame.AddClient.addActionListener(this);
   this.PFrame.AddBook.addActionListener(this);
   this.PFrame.ListClient.addActionListener(this);
   this.PFrame.ListBook.addActionListener(this);
   


}

    @Override
    public void actionPerformed(ActionEvent e) {
        
       switch(e.getActionCommand()){
       
           case "addClient":
               
              
            CUsuario = new CtrUsuario(PFrame);
            
            
            
               
             break;
           
           
       
       
       }
        
    }
 
}
