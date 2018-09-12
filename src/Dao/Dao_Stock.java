/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.Connex.con;
import Entite.Stock;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Josué Dikoma
 */
public class Dao_Stock implements ModelDao<Stock>{
    static Connection con=con=Connex.getConnection();
    static PreparedStatement pstm=null;
    static ResultSet rs=null;
    @Override
    public int Enregistrer(Stock object) {
        String requette="INSERT INTO `affelpharma`.`stock` (`idProduit`, `libelleProduit`,`quantiteDispo`, `prixUnitaire`) VALUES (?,?,?,?);";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous Ajouter  '"+object.getLibelleProduit().getLibelleProduit()+"'?","Enregistement", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
     
        try {
           pstm=con.prepareStatement(requette);
           pstm.setInt(1, object.getIdProduit().getIdProduit());
           pstm.setString(2, object.getLibelleProduit().getLibelleProduit());
           pstm.setDouble(3, object.getQuantite());
           pstm.setDouble(4, object.getPrixUnitaire());
                       
            JOptionPane.showMessageDialog(null, "Ajout reussi","Ajout produit", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ajout annulé", "Ajout Produit au stock", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    @Override
    public int Modifier(Stock object) {
                String requette="update `affelpharma`.`stock` set `libelleProduit`=?,`quantiteDispo`=?, `prixUnitaire`=? where idProduit=?;";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous Modifier  ?'"+object.getLibelleProduit().getLibelleProduit()+"'?","Modification", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
     
        try {
           pstm=con.prepareStatement(requette);
          
           pstm.setString(1, object.getLibelleProduit().getLibelleProduit());
           pstm.setDouble(2, object.getQuantite());
           pstm.setDouble(3, object.getPrixUnitaire());
            pstm.setInt(4, object.getIdProduit().getIdProduit());
                       
            JOptionPane.showMessageDialog(null, "Modification reussie","Modification Stock", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Modification annulée", "Modification Produit au stock", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }
    

    @Override
    public int Supprimer(Stock object) {
               String requette="delete from `affelpharma`.`stock` where idProduit=?;";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Supprimer ce produit du stock  ?","Modification", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
     
        try {
            pstm=con.prepareStatement(requette);
         
            pstm.setInt(1, object.getIdProduit().getIdProduit());
                       
            JOptionPane.showMessageDialog(null, "Suppression effectuée","Modification Stock", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Suppression annulée", "Modification stock", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }
     public static void AfficherTabStock1(JTable jt)
    {
        try {
            String sql="select * from stock" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        } 
    }
      public static void RemplirLibelle(JComboBox jc1)
     {
         jc1.removeAllItems();
        try {
            String sql="select libelleProduit from produit" ;
            pstm=con.prepareStatement(sql);
        rs=pstm.executeQuery();
            while (rs.next()) {
                String Id= rs.getString("libelleProduit");
                jc1.addItem(Id);
                
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
        }      
     }
      
     public static void RemplirIdProduit(JComboBox jc1, JComboBox jc2)
     {
          
        jc1.removeAllItems();
         System.out.println("jod");
        try {
            String sql="SELECT idProduit FROM produit where libelleProduit=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1, jc2.getSelectedItem().toString());
            rs=pstm.executeQuery();
            while (rs.next()) {
              int Id= rs.getInt("idProduit");
                jc1.setSelectedItem(Id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
     }
     
     public static int VerifierRedondance(JComboBox jt1)
    {
        String sql="Select * from stock where libelleProduit=?";
        try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1, jt1.getSelectedItem().toString());
            rs= pstm.executeQuery();
            if (rs.next()) {
                return 1;      
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return 0;
    }
     
         public static void AfficherTabStock2(JTable jt)
    {
        try {
            String sql="SELECT libelleProduit, quantiteDispo, prixUnitaire, quantiteDispo * prixUnitaire as PrixTotal FROM affelpharma.stock;" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        } 
    } 
         
//          public static void RemplirLibelleRech(JComboBox jc1)
//     {
//         jc1.removeAllItems();
//        try {
//            String sql="SELECT * FROM affelpharma.produit WHERE nomScientifique like %?%;" ;
//            pstm=con.prepareStatement(sql);
//            pstm.setString(1, jc1.getSelectedItem().toString());
//        rs=pstm.executeQuery();
//            while (rs.next()) {
//                String Id= rs.getString("libelleProduit");
//                jc1.addItem(Id);
//                
//            }
//        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
//        }      
//     }  
    
    
}
