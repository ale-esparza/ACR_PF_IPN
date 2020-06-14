/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_socekts;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Mariel Lopez Beltran
 * Alejandra Montserrath Esparza Rios
 * Proyecto: Chat con sockets 
 * Descripcion: Se llevo acabo la realizacion de un chat con sockets e hilos por el cual debera de ser posible que se
 * conectan mas de 2 usuarios 
 */
public class ChatClienteGUI extends javax.swing.JFrame {
     Socket cliente;
     String idC,clientesID;
    DataInputStream entrada;
    DataOutputStream salida;
    InputStream entra;
    DefaultListModel dm;
    File archivo;
    final int bufferC = 100;
    String direccion="src/Documentos/";
    
    public String getDireccion() {
        return direccion;
    }
    /**
     * Creates new form ChatClienteGUI
     */
    public ChatClienteGUI() {
        initComponents();
    }
    ChatClienteGUI(String id,Socket c){
        cliente=c;
        idC=id;
         try {  
                       initComponents();
                        dm = new DefaultListModel();
                     
                        userN.setText(id);
			entrada = new DataInputStream(cliente.getInputStream()); 
			salida = new DataOutputStream(cliente.getOutputStream());
			new Lectura_Mensaje(cliente,idC,chatM,entrada,dm).start(); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatM = new javax.swing.JTextArea();
        Enviar = new javax.swing.JButton();
        mensajeE = new java.awt.TextField();
        label2 = new java.awt.Label();
        userN = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setText("Usuario:");

        chatM.setColumns(20);
        chatM.setFont(new java.awt.Font("MS Gothic", 0, 14)); // NOI18N
        chatM.setRows(5);
        jScrollPane1.setViewportView(chatM);

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        mensajeE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeEActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setText("Mensaje:");

        userN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton1.setText("Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Salir.setText("Salir");

        jButton2.setText("Abrir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userN, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(Salir)
                                    .addGap(229, 229, 229)
                                    .addComponent(jButton2))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mensajeE, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(Enviar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mensajeE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Enviar)
                                    .addComponent(jButton1))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        // TODO add your handling code here:
      try{
          String m = mensajeE.getText();
          String cId=idC;
          
          //Mensajes que el usuario le mandara a los otros usuarios
          if(!m.isEmpty()){
              //m=""+cId;
              salida.writeUTF(m);
              mensajeE.setText("");
              chatM.append("\n TU:"+" "+m);
          }
          else{
              salida.writeUTF(m);
              mensajeE.setText("");
            
               JOptionPane.showMessageDialog(null,"No has escrito nada");
          }
          
      }catch(Exception ex){
          ex.printStackTrace();
      }
    }//GEN-LAST:event_EnviarActionPerformed

    private void mensajeEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mensajeEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
             // TODO add your handling code here:
             abrirArchivo();
         } catch (IOException ex) {
             Logger.getLogger(ChatClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        File Archivo=new File("C"+archivo);    
            BufferedWriter bw; 
            FileOutputStream fis;
         try {
             fis = new FileOutputStream(Archivo);
              BufferedOutputStream bis = new BufferedOutputStream(fis); //Buffer de salida para poder leer archivos 
            bw = new BufferedWriter(new FileWriter(Archivo)); 
            //Escribe lo que el servidor ha mandado a nuestro cliente              
            int c;
            entra = cliente.getInputStream();
            while((c=entrada.read())!=-1)
            bis.write(c);
            bis.flush();
            System.out.println("He creado al archivo");            
            //Limpia el archivo
            bw.close();
            fis.close();
            bis.close();   
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ChatClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ChatClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }//GEN-LAST:event_jButton2ActionPerformed
private void abrirArchivo() throws IOException {
  
   /**llamamos el metodo que permite cargar la ventana*/
   JFileChooser file=new JFileChooser();
   file.showOpenDialog(this);
   /**abrimos el archivo seleccionado*/
    archivo=file.getSelectedFile();
   mensajeE.setText(archivo.toString());
   enviarArchivo();
    
 
  
 
  
}
private void enviarArchivo() throws IOException{
            salida = new DataOutputStream(cliente.getOutputStream());
            File file = new File(archivo.toString());
            int by = (int) file.length();
            int tamanio = (int)Math.ceil(by/bufferC);
           
            salida.writeUTF("Enviando"+" "+ tamanio +" ");
            InputStream entrada = new FileInputStream(file);
            OutputStream salida = cliente.getOutputStream();
           //Lectura de archivo
            BufferedInputStream bis = new BufferedInputStream(entrada);
          
            byte[] buffer = new byte[bufferC];
            int con, por = 0;
            while((con = bis.read(buffer)) > 0){
                por = por + con;
                int pT = (por/tamanio);
            }
            chatM.append("El archivo fue enviado.");
        
            salida.flush();
            salida.close();
         
}
    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClienteGUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private javax.swing.JButton Salir;
    private javax.swing.JTextArea chatM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextField mensajeE;
    private java.awt.Label userN;
    // End of variables declaration//GEN-END:variables
}

