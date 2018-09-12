/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entite.Produit;
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
public class Dao_Produit implements ModelDao<Produit>{
    static Connection con=con=Connex.getConnection();
    static PreparedStatement pstm=null;
    static ResultSet rs=null;
    @Override
    public int Enregistrer(Produit object) {
         String requette="INSERT INTO `affelpharma`.`produit` (`libelleProduit`, `nomScientifique`, `typeProduit`,  `embProduit`, `doseProduit`,`fabriquantProduit`) VALUES (?,?,?,?,?,?);";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Ajouter  '"+object.getLibelleProduit()+"'?","Enregistement", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
     
        try {
            pstm=con.prepareStatement(requette);
            pstm.setString(1, object.getLibelleProduit().toUpperCase());
            pstm.setString(2, object.getNomScientifique().toUpperCase());
            pstm.setString(3, object.getTypeProduit().toUpperCase());
            pstm.setString(4, object.getEmballageProduit().toUpperCase());
            pstm.setString(5, object.getDoseProduit().toUpperCase());
            pstm.setString(6, object.getFabriquantProduit().toUpperCase());
            JOptionPane.showMessageDialog(null, "Ajout reussi","Ajout produit", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ajout annulé", "Ajout Produit", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
        
       
    }

    @Override
    public int Modifier(Produit object) {
       String requette="update `affelpharma`.`produit` set `libelleProduit`=?, `nomScientifique`=?, `typeProduit`=?,`embProduit`=?,`doseProduit`=?,`fabriquantProduit`=?  where idProduit=?;";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment modifier  '"+object.getLibelleProduit()+"'?","Modification", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
       JOptionPane.showMessageDialog(null, "Modification reussie","Modification produit", JOptionPane.INFORMATION_MESSAGE);
                try
        {
            pstm=con.prepareStatement(requette);
            pstm.setString(1, object.getLibelleProduit().toUpperCase());
            pstm.setString(2, object.getNomScientifique().toUpperCase());
            pstm.setString(3, object.getTypeProduit().toUpperCase());
            pstm.setString(4, object.getEmballageProduit().toUpperCase());
            pstm.setString(5, object.getDoseProduit().toUpperCase());
            pstm.setString(6, object.getFabriquantProduit().toUpperCase());
            pstm.setInt(7, object.getIdProduit());   
            
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
    public int Supprimer(Produit object) {
                String requette="delete from `affelpharma`.`produit` where idProduit=?;";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Supprimer  ce Produit ?","Suppression", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
            pstm.setInt(1, object.getIdProduit());
            JOptionPane.showMessageDialog(null, "Suppression reussie","Suppression Produit", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Suppression annulée", "Suppression Produit", JOptionPane.INFORMATION_MESSAGE);
            
            }
        
        
        
        return 0;
    }
    public static void AfficherTabProduit(JTable jt)
    {
        try {
            String sql="select * from produit" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        } 
    }
    public static void AfficherTabProduitListes(JTable jt)
    {
        try {
            String sql="select libelleProduit, nomScientifique, typeProduit, embProduit, doseProduit, fabriquantProduit from produit" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        } 
    }
    public static int VerifierRedondance(JTextField jt1)
    {
        String sql="Select * from produit where libelleProduit=?";
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
