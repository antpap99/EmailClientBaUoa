/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.emailclient;
import java.io.File;
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
    public static String username;
    public static String password;
    public static String host;
    
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
