/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_socekts;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Lectura_Mensaje extends Thread{
    Socket cliente;
    InputStream entrada;
    OutputStream saliA;
    DataInputStream mensaje_Entrada;
    DataOutputStream mensaje_Salida;
    JTextArea area;
    String name;
    JList dm;
    DefaultListModel es;
    
    
    public Lectura_Mensaje(Socket s,String name,JTextArea area,DataInputStream mE,DefaultListModel a){
        this.cliente=s;
        this.area=area;
        this.name=name;
        this.mensaje_Entrada=mE;
        this.es=a;
        
    }
    public void run(){
      //  es = new DefaultListModel();
        while(true){
            try {
                String ms=mensaje_Entrada.readUTF();
                if(ms.contains(":;.,/=")){
                   ms= ms.substring(6);
                
	          // dm.setModel(es);
                    es.clear();
                   StringTokenizer e=new StringTokenizer(ms,",");
                   while(e.hasMoreTokens()){
                       String u=e.nextToken();
                       if(!name.equals(u)){
                         es.addElement(u);
                       }
                   }
                   
                }
                else{
                    area.append(""+ms+"");
                }
            } catch (IOException ex) {
                break;
            }
            
        }
    }
    }

    

