/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.Controller_User;
import Entite.User;
import java.awt.Component;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Josué Dik
 */
public class Dao_User implements ModelDao<User>{
    static Connection con=con=Connex.getConnection();
    static PreparedStatement pstm=null;
    static ResultSet rs=null;

//    public Dao_User() {
//        try {
//            con=Connex.getConnection();
//            
//        } catch (Exception e) {System.out.println(e.getMessage());
//        }
//    }

    @Override
    public int Enregistrer(User object) {
        String requette="INSERT INTO `affelpharma`.`user` (`nomUser`, `postnomUser`, `typeUser`,  `emailUser`, `loginUser`, `passUser`) VALUES (?,?, ?, ?, ?, ?);";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment enregistrer  '"+object.getNomUser()+"'?","Enregistement", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
            pstm.setString(1, object.getNomUser());
            pstm.setString(2, object.getPostnomUser());
            pstm.setString(3, object.getTypeUser());
            pstm.setString(4, object.getEmailuser());
            pstm.setString(5, object.getLoginUser());
            pstm.setString(6, object.getPassUser());
            JOptionPane.showMessageDialog(null, "Enregistement reussi","Enregistrement Utilisateur", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enregistement annulé", "Enreigistrement", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    @Override
    public int Modifier(User object) {
        String requette="update `affelpharma`.`user` set nomUser=? ,postnomUser=?, typeUser=?, emailUser=?, loginUser=?, passUser=? where idUser=?";
        
               int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Modifier?","Mise a jour utilisateur", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                try {
            pstm=con.prepareStatement(requette);
            pstm.setString(1, object.getNomUser().toUpperCase());
            pstm.setString(2, object.getPostnomUser().toUpperCase());
            pstm.setString(3, object.getTypeUser().toUpperCase());
            pstm.setString(4, object.getEmailuser().toUpperCase());
            pstm.setString(5, object.getLoginUser().toUpperCase());
            pstm.setString(6, object.getPassUser().toUpperCase());
            pstm.setInt(7, object.getIdUser());
            JOptionPane.showMessageDialog(null, "Mise a jour reussie","Mise a jour Utilisateur", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Modification annulée", "Modification Utilisateur", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    
    @Override
    public int Supprimer(User object) {
        String sql="delete from user where idUser=?";
        int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Supprimer cet utilisateur ?","Suppression utilisateur", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                
            try {
                pstm=con.prepareStatement(sql);
                pstm.setInt(1, object.getIdUser());
                JOptionPane.showMessageDialog(null, "Suppression reussie","Suppression utilisateur ", JOptionPane.INFORMATION_MESSAGE);
                return pstm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_User.class.getName()).log(Level.SEVERE, null, ex);
            }
                               
            }
            else{
                JOptionPane.showMessageDialog(null, "Suppression annulée","Suppression utilisateur ", JOptionPane.INFORMATION_MESSAGE);
            
            }
            return 0;
    }
    
    public static int SeLoger(JTextField jt1, JPasswordField jp1)
    {
        try {
            //jai failli mourir dans cette partie du code je vous jure'
            String sql="select * from user where  loginUser=? and passUser=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1,jt1.getText());
            pstm.setString(2, jp1.getText());       
            rs=pstm.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenu  "+ jt1.getText().toUpperCase() +" !", "Connecté", JOptionPane.INFORMATION_MESSAGE);
                return 1;
            }
            else{
               JOptionPane.showMessageDialog(null, "Login et/ou mot de passe incorrect/s"); 
               return 2;
               
            }  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public static int VerifierAdmin() throws SQLException
    {
           String result=JOptionPane.showInputDialog(null, "Saisir le mot de passe d'un admin", "Verification Admin", JOptionPane.WARNING_MESSAGE).toString();
           
          
               String sql="select * from user where typeUser='admin' and passUser=? ";
           pstm=con.prepareStatement(sql);
           pstm.setString(1, result);
           rs=pstm.executeQuery();
               if (rs.next()) {
                  
                  return 1; 
               }
            
           return 0;
    }
         public static void AfficherTabUser(JTable jt)
    {
        try {
            String sql="select * from user" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        }
    
    }
             public static int VerifierRedondance(JTextField jt1, JTextField jt2)
    {
        String sql="Select * from user where nomUser=? and postnomUser=?";
        try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1, jt1.getText());
            pstm.setString(2, jt2.getText());
            rs= pstm.executeQuery();
            if (rs.next()) {
                return 1;      
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return 0;
    }
    
}
