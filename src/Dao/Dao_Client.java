/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entite.Client;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Josué Dikoma
 */
public class Dao_Client implements ModelDao<Client>{

    static Connection con=con=Connex.getConnection();
    static PreparedStatement pstm=null;
    static ResultSet rs=null;
    @Override
    public int Enregistrer(Client object) {
        String requette="INSERT INTO `affelpharma`.`client` (`nomsClient`, `typeClient`, `communeClient`,  `adresseClient`) VALUES (?,?,?,?);";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment enregistrer  '"+object.getNomsClient()+"'?","Enregistement", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Ajout reussi","Ajout Client", JOptionPane.INFORMATION_MESSAGE);
        try {
            pstm=con.prepareStatement(requette);
            pstm.setString(1, object.getNomsClient().toUpperCase());
            pstm.setString(2, object.getTypeClient().toUpperCase());
            pstm.setString(3, object.getCommuneClient().toUpperCase());
            pstm.setString(4, object.getAdresseClient().toUpperCase());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ajout annulé", "Ajout Client", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    @Override
    public int Modifier(Client object) {
              String requette="update `affelpharma`.`client` set `nomsClient`=?, `typeClient`=?, `communeClient`=?,  `adresseClient`=? where idClient=?;";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment modifier  '"+object.getNomsClient()+"'?","Modification", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Modification reussie","Ajout produit", JOptionPane.INFORMATION_MESSAGE);
        try {
            pstm=con.prepareStatement(requette);
            pstm.setString(1, object.getNomsClient().toUpperCase());
            pstm.setString(2, object.getTypeClient().toUpperCase());
            pstm.setString(3, object.getCommuneClient().toUpperCase());
            pstm.setString(4, object.getAdresseClient().toUpperCase());
            pstm.setInt(5, object.getIdClient());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Modification annulée", "Modification Client", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    @Override
    public int Supprimer(Client object) {
        String requette="delete from `affelpharma`.`client` where idClient=?;";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Supprimer  '"+object.getNomsClient()+"'?","Suppression", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Suppression reussie","Ajout Client", JOptionPane.INFORMATION_MESSAGE);
        try {
            pstm=con.prepareStatement(requette);
            pstm.setInt(1, object.getIdClient());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Suppression annulée", "Suppression Client", JOptionPane.INFORMATION_MESSAGE);
            
            }
        
        
        
        return 0;
    }
        public static void AfficherTabClient(JTable jt)
    {
        try {
            String sql="select * from client" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        }
    
    }
    
     public static int VerifierRedondance(JTextField jt1)
    {
        String sql="Select * from client where nomsClient=?";
        try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1, jt1.getText());
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
