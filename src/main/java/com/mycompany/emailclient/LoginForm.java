/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.emailclient;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.*;
import javax.mail.Address;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

/**
 *
 * @author antpap
 */
public class LoginForm extends javax.swing.JFrame {
    public ArrayList<Message> messageList;
    EmailClient emailclient = new  EmailClient();
    
    /**
     * Creates new form LoginForm
     */ 
    public LoginForm() {
        
        initComponents();
    }
    
     public class EmailReceiver {
        //private ArrayList<Message> messageList;
         public boolean validateCredentials(String host, String username, String password) {
                // Create a Properties object and set the IMAP server properties
                Properties props = new Properties();
                
                props.put("mail.store.protocol", "imaps");
                props.put("mail.imaps.host", host);
                props.put("mail.imaps.port", "993");
                props.put("mail.imaps.ssl.enable", "true");
                
                // Create a Session instance
                //Session session = Session.getDefaultInstance(props);
                try {
                Session emailSession = Session.getInstance(props);
                Store store = emailSession.getStore("imaps");
                emailSession.setDebug(true);
                // Connect to the IMAP server
                store.connect(host, username, password);

                Folder emailFolder = store.getFolder("INBOX");
                emailFolder.open(Folder.READ_ONLY);

                Message[] messages = emailFolder.getMessages();
                messageList = new ArrayList<>(); // Create a new ArrayList
                Collections.addAll(messageList, messages); // Add all messages to the ArrayList
                System.out.println("Number of emails: " + messages.length);
                System.out.println("List of emails: " + messageList);
                ArrayList <String> subjects = new ArrayList<>();
                // Example: Print out subject of each email
                for (Message message : messages) {
                    String Subject = message.getSubject();
                    Date date = message.getSentDate();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String datestring = formatter.format(date);
                    emailclient.subject.add(0, Subject);//πρωτο subject ειναι ιδιοηττα του αντικειμενου , δευτερο ειναι τοποικη μεταβλητη
                    emailclient.date.add(0, datestring); // το 0 υποδηλωνει εισαγωγη στην κορυφη της ArrayList
                    Address [] from = message.getFrom();
                    for(Address address : from){
                        if (address instanceof InternetAddress){
                            InternetAddress internetFrom = (InternetAddress) address;
                            String FROM1 = internetFrom.getAddress();
                            String FROM2 = internetFrom.getPersonal();
                            String FROM = FROM2 + " , " + FROM1;
                            emailclient.from.add(0, FROM); // το 0 υποδηλωνει εισαγωγη στην κορυφη της ArrayList
                        }
                        if(message instanceof MimeMessage){
                            MimeMessage mimeMessage = (MimeMessage) message;
                            try{
                                Object content = mimeMessage.getContent();
                                if(content instanceof String){
                                    String textContent = (String) content;
                                } else if (content instanceof Multipart){
                                    Multipart multipart = (Multipart) content;
                                    for(int i = 0; i < multipart.getCount(); i++){
                                        BodyPart bodyPart = multipart.getBodyPart(i);
                                        if(bodyPart.isMimeType("text/plain")){
                                            String plainText = (String) bodyPart.getContent();
                                            emailclient.text.add(0, plainText);
                                        }
                                    }
                                }
                            }catch (IOException | MessagingException e) {
                                    // Χειρισμός σφάλματος
                            }       
                        }
                    }
                }
                emailFolder.close(false);
                    store.close();
                } catch (NoSuchProviderException e) {
                            e.printStackTrace();
                            return false;
                } catch (MessagingException e) {
                            e.printStackTrace();
                            return false;
                }
            return true;
        }
   }
   // Method to retrieve the current username
    public String getUsername() {
       String username = TextEmail.getText();
       return username;
  }
 
   // Method to retrieve the current password
   public  String getPassword() {
       String password = new String(TextPassword.getPassword());
       return password;    
  }
   public ArrayList<Message> getMessages (){
       return messageList;
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jMenu1 = new javax.swing.JMenu();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        lblPassword = new javax.swing.JLabel();
        TextPassword = new javax.swing.JPasswordField();
        TextEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        BtnLogin = new javax.swing.JButton();
        lblServer = new javax.swing.JLabel();
        TextServer = new javax.swing.JTextField();
        checkboxShowPassword = new javax.swing.JCheckBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        lblPassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPassword.setText("Password");

        TextPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPasswordActionPerformed(evt);
            }
        });

        TextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEmailActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEmail.setText("Email");

        BtnLogin.setBackground(new java.awt.Color(102, 153, 255));
        BtnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogin.setText("Login");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        lblServer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblServer.setText("Server");

        TextServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextServerActionPerformed(evt);
            }
        });

        checkboxShowPassword.setText("Show Password");
        checkboxShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(lblServer, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(TextServer, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(TextPassword)))
                    .addComponent(checkboxShowPassword))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkboxShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServer)
                    .addComponent(TextServer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(BtnLogin)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPasswordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TextPasswordActionPerformed

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        
    // TODO add your handling code here:
            String username = TextEmail.getText();
            emailclient.username = username ;
            String host = TextServer.getText();
            String password = new String(TextPassword.getPassword());
            emailclient.password = password ;
            emailclient.host = host ;
            
        // Perform email validation
        EmailReceiver emailReceiver = new EmailReceiver();
        boolean isAuthenticated = emailReceiver.validateCredentials(host, username, password);
        
        if (isAuthenticated == true ) {
            // Authentication successful, proceed with login
            openGetMailFrame();
        } else {
            // Authentication failed, display error message to user
            JOptionPane.showMessageDialog(this, "Login not successful. Please check your email and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnLoginActionPerformed
    private void openGetMailFrame() {
        getmail getMailFrame = new getmail();
        getMailFrame.setVisible(true);
        JOptionPane.showMessageDialog(this, "Login successful", "Login Succesful", JOptionPane.INFORMATION_MESSAGE  );
        getMailFrame.getAttributes();
        this.dispose(); // Close the current login frame
        
    }
    private void TextServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextServerActionPerformed

    private void TextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEmailActionPerformed

    private void checkboxShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxShowPasswordActionPerformed
        // TODO add your handling code here:
        if (checkboxShowPassword.isSelected()){
            TextPassword.setEchoChar((char)0);
        }
        else{
            TextPassword.setEchoChar(('*'));
        }
    }//GEN-LAST:event_checkboxShowPasswordActionPerformed

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
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogin;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JTextField TextServer;
    private javax.swing.JCheckBox checkboxShowPassword;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblServer;
    // End of variables declaration//GEN-END:variables

}