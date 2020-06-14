/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
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
public class Introducir_Cliente extends Thread{
    Socket cliente;
    HashMap clientesC;
    JTextArea ar;
    JList as ;
    DefaultListModel asc;
    
    public Introducir_Cliente(HashMap cl,Socket c,JTextArea a){
        clientesC=cl;
        cliente=c;
        ar=a;
      
    }
    
    public void run(){
        try{
        String ids="";
        Set k = clientesC.keySet();
        Iterator itr=k.iterator();
        while(itr.hasNext()){
            String key=(String)itr.next();
            ids+=key+"";
           // as.setModel(asc);
           // asc.addElement(ids);
        }
        if(ids.length()!=0){
            ids=ids.substring(0,ids.length()-1);
            itr=k.iterator();
            while(itr.hasNext()){
                String key=(String)itr.next();
                try{
                    new DataOutputStream(((Socket)clientesC.get(key)).getOutputStream()).writeUTF(ids);
                }catch(Exception e){
                    e.printStackTrace();
                    clientesC.remove(key);
                    ar.append("Removido");
                    
                }
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
}

