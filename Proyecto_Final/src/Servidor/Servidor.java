/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import java.awt.Label;
import java.awt.TextField;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Mariel Lopez Beltran
 * Alejandra Montserrath Esparza Rios
 * Proyecto: Chat con sockets 
 * Descripcion: Se llevo acabo la realizacion de un chat con sockets e hilos por el cual debera de ser posible que se
 * conectan mas de 2 usuarios 
 */
public class Servidor {
    public ServerSocket servidor;
    public Socket cliente;
    public HashMap clientesC = new HashMap();
    public int puerto=1234;
    public DataOutputStream salida;
    public DataInputStream entrada;
    public JTextArea area;
    public Label ser;
    
    //Servidor, en este caso esta esperando a que un cliente se conecte
    
    public Servidor(Label a,JTextArea are) throws IOException{
        this.ser=a;
        this.area=are;
        
        servidor = new ServerSocket(puerto);
        a.setText("Servidor a la escucha en el puerto:"+puerto);
        area.append("Esperando clientes... \n");
        new ClienteAcepte(servidor,clientesC,area,entrada).start();
    }
    public void cerrar() throws IOException{
        servidor.close();
    }
}



