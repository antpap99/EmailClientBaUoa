/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emailclient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author antonis
 */
public class Database {
    
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER = "root";
    private static final String PASSWORD = "antonis3110";
    
    public static void main(String[] args) {


    try {
            // Φόρτωσε την κλάση του MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Σύνδεση με τη βάση δεδομένων
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected to the database");
            
            

            // Κλείσε τη σύνδεση
            connection.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("JDBC Driver not found.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.err.println("SQL Exception.");
            ex.printStackTrace();
        }
    }
}
