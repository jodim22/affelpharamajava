/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entite.Vente;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Josué Dikoma
 */
public class Dao_Vente implements ModelDao<Vente>{
    static Connection con=con=Connex.getConnection();
    static PreparedStatement pstm=null;
    static ResultSet rs=null;

    @Override
    public int Enregistrer(Vente object) {
        String requette="INSERT INTO `affelpharma`.`vente` (`dateVente`,`idProduit`, `libelleProduit`,  `prixunitaire`, `quantiteVente`) VALUES (?,?,?,?,?);";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Ajouter  '"+object.getNomProduit().getLibelleProduit()+"'?","Enregistement", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
         pstm.setDate(1,  java.sql.Date.valueOf(object.getDateVente()));
            //pstm.setDate(1, java.s);
            pstm.setInt(2, object.getIdProduit().getIdProduit());
            pstm.setString(3, object.getNomProduit().getLibelleProduit());
            pstm.setDouble(4, object.getPrixunitaireProduit());
            pstm.setDouble(5, object.getQuantiteProduit());
            
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ajout annulé", "Ajout Vente", JOptionPane.INFORMATION_MESSAGE);
            
            }
            JOptionPane.showMessageDialog(null, "Ajout reussi","Ajout Vente", JOptionPane.INFORMATION_MESSAGE);
        return 0;
    }

    @Override
    public int Modifier(Vente object) {
        String requette="update `affelpharma`.`vente` set `dateVente`=?,`idProduit`=?, `libelleProduit`=?,  `prixunitaire`=?,`quantiteVente`=? where idVente=?;";
            int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Modifier  '"+object.getNomProduit().getLibelleProduit()+"'?","Modification", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Modification reussie","Modification Vente", JOptionPane.INFORMATION_MESSAGE);
        try {
            pstm=con.prepareStatement(requette);
           pstm.setDate(1, java.sql.Date.valueOf(object.getDateVente()));
            pstm.setInt(2, object.getIdProduit().getIdProduit());
            pstm.setString(3, object.getNomProduit().getLibelleProduit());
            pstm.setDouble(4, object.getPrixunitaireProduit());
            pstm.setDouble(5, object.getQuantiteProduit());
            pstm.setInt(6, object.getNumVente());
            
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Modification annulé", "Modification Vente", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    @Override
    public int Supprimer(Vente object) {
        String requette="delete from `affelpharma`.`vente`  where idVente=?;";
            int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Modifier ?","Suppression", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
            pstm.setInt(1, object.getNumVente());
            JOptionPane.showMessageDialog(null, "Suppression reussie"," Suppression Vente", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Suppression annulée", "Suppression Vente", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }
    
         public static void AfficherTabVente(JTable jt)
    {
        try {
            String sql="SELECT * from vente;" ;         
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            jt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
        } 
    }
         
             public static void RemplirLibelleVente(JComboBox jc1)
     {
         jc1.removeAllItems();
        try {
            String sql="select libelleProduit from stock" ;
            pstm=con.prepareStatement(sql);
        rs=pstm.executeQuery();
            while (rs.next()) {
                String Id= rs.getString("libelleProduit");
                jc1.addItem(Id);
                
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
        }      
     }
             
         public static void RemplirIdProduit(JComboBox jc1, JComboBox jc2, JTextField jt1, JTextField jt2)
     {
          
        jc1.removeAllItems();
        try {
            String sql="SELECT idProduit, prixUnitaire,quantiteDispo FROM stock where libelleProduit=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1, jc2.getSelectedItem().toString());
            rs=pstm.executeQuery();
            while (rs.next()) {
              int Id= rs.getInt("idProduit");
                jc1.setSelectedItem(Id);
              double prix=rs.getDouble("prixUnitaire");
              jt1.setText(String.valueOf(prix));
              double qte=rs.getDouble("quantiteDispo");
              jt2.setText(String.valueOf(qte));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
     }     
    
}
