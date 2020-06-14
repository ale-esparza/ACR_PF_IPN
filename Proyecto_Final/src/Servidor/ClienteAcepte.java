/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import java.io.*;
import java.net.*;
import java.util.HashMap;
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
public class ClienteAcepte extends Thread{
    public ServerSocket servidor;
    public Socket cliente;
    public DataOutputStream salida;
    public DataInputStream entrada;
    public InputStream entradaC;
    public OutputStream salidaC;
    public HashMap clientes;
    public String mensajeEntrada;
    public String mensajeSalida;
    public JTextArea area;
    
    public ClienteAcepte(ServerSocket ser,HashMap cl,JTextArea a,DataInputStream e){
        servidor=ser;
        clientes = cl;
        area=a;
        this.entrada=e;
       
    }
    
    @Override
    public void run(){
        //Cuando el cliente acepte debera de verificar que el usuario no exista
        try {
            while(true){
            cliente = servidor.accept();
            mensajeEntrada= new DataInputStream(cliente.getInputStream()).readUTF();
            if(clientes.containsKey(mensajeEntrada)){
                salida=new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF("El Usuario ingresado ya  esta registrado");
                
            }else{
                clientes.put(mensajeEntrada, cliente);
                area.append("\n"+mensajeEntrada+": se ha unido\n");
                salida=new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF("");
                new Mensaje(cliente,mensajeEntrada,clientes,area).start();
            }
        }
        }catch (IOException ex) {
            Logger.getLogger(ClienteAcepte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
