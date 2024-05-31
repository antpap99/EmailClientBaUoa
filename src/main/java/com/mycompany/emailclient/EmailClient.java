/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.emailclient;
import static com.mycompany.emailclient.EmailClient.date;
import static com.mycompany.emailclient.EmailClient.from;
import static com.mycompany.emailclient.EmailClient.mail;
import static com.mycompany.emailclient.EmailClient.subject;
import static com.mycompany.emailclient.EmailClient.text;
import java.util.ArrayList;
import javax.mail.*;
/**
 *
 * @author antpap
 */
public class EmailClient {
    
    public EmailClient(){
    
    }
        public static ArrayList<ArrayList<String>> mail = new ArrayList<>(); //οριζουμε την λιστα απο λιστες
        public static ArrayList<String> subject = new ArrayList<>();//static διοτι μπορω να το αλλαξω απο τις αλλες κλασεις,ωστοσο οταν αλλαζει κατι για ενα αντικειμενο αλλαζει ταυτοχρονα για ολα δεδομενου της static υποστασης.
        public static ArrayList<String> from = new ArrayList<>();
        public static ArrayList<String> text = new ArrayList<>();
        public static ArrayList<String> date = new ArrayList<>();
    
    
          public static void main(String args[]) {                 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
        
    

     
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
        mail.add(from);
        mail.add(subject);
        mail.add(date);
        mail.add(text);
    }
}
