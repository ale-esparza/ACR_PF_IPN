/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_socekts;
import java.awt.Label;
import java.awt.TextField;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Mariel Lopez Beltran
 * Alejandra Montserrath Esparza Rios
 * Proyecto: Chat con sockets 
 * Descripcion: Se llevo acabo la realizacion de un chat con sockets e hilos por el cual debera de ser posible que se
 * conectan mas de 2 usuarios 
 */
public class Cliente_Registro {
    String name;
    Socket cliente;
    InputStream entrada;
    OutputStream salida;
    DataOutputStream mensaje_Salida;
    DataInputStream mensaje_Entrada;
    TextField nombre;
  
   
    //El login en el que el usuario esta iniciando sesion;
    public Cliente_Registro(TextField n) throws IOException{
        nombre=n;  
        name=nombre.getText();
        cliente = new Socket("localhost",1234);
        mensaje_Entrada=new DataInputStream(cliente.getInputStream());
        mensaje_Salida=new DataOutputStream(cliente.getOutputStream());
        mensaje_Salida.writeUTF(name);
        String mensaje=mensaje_Entrada.readUTF();
        if(mensaje.equals(name)){
            JOptionPane.showMessageDialog(null,"El usuario ya esta registrado....");
        }else{
              //new Registro_Clientes().setVisible(false);
              new  ChatClienteGUI(name,cliente).setVisible(true);
             // vis.dispose();
             
        }
        
        
    }
    
}
