/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josué Dik
 */
public class Connex {
    public static Connection con;
    
    public static Connection getConnection ()
    {
        
         String user = "root";
        String pass = "";
        String db = "affelpharma";
        String sgbd = "jdbc:mysql://localhost:3306/" + db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(sgbd, user, pass);
            System.out.println("Connexion Ok");
            return con;
        } catch (SQLException e) {System.out.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
}
