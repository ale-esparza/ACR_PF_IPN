/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import Chat_socekts.ChatClienteGUI;
import Servidor.Introducir_Cliente;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextArea;
/**
 *
 * @author Mariel Lopez Beltran
 * Alejandra Montserrath Esparza Rios
 * Proyecto: Chat con sockets 
 * Descripcion: Se llevo acabo la realizacion de un chat con sockets e hilos por el cual debera de ser posible que se
 * conectan mas de 2 usuarios 
 */
//Los mensajes que apareceran en el chat de forma global 
public class Mensaje extends Thread {
    Socket cliente;
    String name;
    HashMap clientes;
    JTextArea area;
   ChatClienteGUI ac;
    JList b;
    public Mensaje(Socket s, String nm,HashMap cl,JTextArea a){
        cliente=s;
        name=nm;
        clientes=cl;
        area=a;
    
    }
    
    @Override
    public void run(){
        while(!clientes.isEmpty()){
            try {
                String mensaje= new DataInputStream(cliente.getInputStream()).readUTF();
                if(mensaje.equals("Salir")){
                    clientes.remove(name);
                    area.append("Se ha desconectado: "+name);
                    
                   // new Introducir_Cliente(clientes).start();        
                    Set<String> k = clientes.keySet();
                    Iterator c = k.iterator();
                    while(c.hasNext()){
                      String llave =(String)c.next();
                      if(!llave.equalsIgnoreCase(name)){
                          try{
                              new DataOutputStream(((Socket)clientes.get(llave)).getOutputStream()).writeUTF("<:"+name+" se ha desconectado");
                              ac.setVisible(false);
                          }catch(Exception e){
                              clientes.remove(llave);
                              //area.append(llave+" ha sido removido");
                                new Introducir_Cliente(clientes,cliente,area).start();         
                          }
                      }                     
                    }
                }
                else{
                    if(mensaje.isEmpty()){
                        
                    }else{
                    Set k = clientes.keySet();
                    Iterator c = k.iterator();
                    while(c.hasNext()){
                      String llave =(String)c.next();
                      if(!llave.equalsIgnoreCase(name)){
                          try{
                          new DataOutputStream(((Socket)clientes.get(llave)).getOutputStream()).writeUTF("\n <:"+name+": "+mensaje);
                          }catch(Exception e){
                              clientes.remove(llave);
                              area.append(llave+"Ha sido removido");
                                new Introducir_Cliente(clientes,cliente,area).start();         
                          }
                }            
            
                   }
                }
                }
                   
            }catch (IOException ex) {
              ex.printStackTrace();
            }
        }
    }
}
