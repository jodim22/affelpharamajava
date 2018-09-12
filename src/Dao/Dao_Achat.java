/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entite.Achat;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Josué Dikoma
 */
public class Dao_Achat implements ModelDao<Achat>{
    static Connection con=con=Connex.getConnection();
    static PreparedStatement pstm=null;
    static ResultSet rs=null;
    @Override
    public int Enregistrer(Achat object) {
         String requette="INSERT INTO `affelpharma`.`achat` (`dateAchat`, `idProduit`, `libelleProduit`,  `prixUnitaire`, `quantiteAchat`,`prixTotal`) VALUES (?,?,?,?,?,?);";
          int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Ajouter  '"+object.getNomProduit().getLibelleProduit()+"'?","Enregistement", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
            pstm.setDate(1, (Date) object.getDateAchat());
            pstm.setInt(2, object.getIdProduit().getIdProduit());
            pstm.setString(3, object.getNomProduit().getLibelleProduit());
            pstm.setDouble(4, object.getPrixunitaireAchat());
            pstm.setDouble(5, object.getQuantiteAchat());
            pstm.setDouble(6, object.getPrixtotalAchat());
            JOptionPane.showMessageDialog(null, "Ajout reussi","Ajout Achat", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ajout annulé", "Ajout Achat", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
        
            
    }

    @Override
    public int Modifier(Achat object) {
            String requette="update `affelpharma`.`achat` set (`dateAchat`=?, `idProduit`=?, `libelleProduit`=?,  `prixUnitaire`=?,`quantiteAchat`=?,`prixTotal`=? ) where idAchat=?;";
            int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Modifier  '"+object.getNomProduit().getLibelleProduit()+"'?","Modification", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
            pstm.setDate(1, (Date) object.getDateAchat());
            pstm.setInt(2, object.getIdProduit().getIdProduit());
            pstm.setString(3, object.getNomProduit().getLibelleProduit());
            pstm.setDouble(4, object.getPrixunitaireAchat());
            pstm.setDouble(5, object.getQuantiteAchat());
            pstm.setDouble(6, object.getPrixtotalAchat());
            pstm.setInt(7, object.getIdAchat());
            JOptionPane.showMessageDialog(null, "Modification reussie","Ajout Achat", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ajout annulé", "Ajout Achat", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }

    @Override
    public int Supprimer(Achat object) {
        String requette="delete from `affelpharma`.`achat`  where idAchat=?;";
            int result= JOptionPane.showConfirmDialog((Component)null, "Voulez vous vraiment Modifier  '"+object.getNomProduit().getLibelleProduit()+"'?","Suppression", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
      
        try {
            pstm=con.prepareStatement(requette);
            pstm.setInt(7, object.getIdAchat());
            JOptionPane.showMessageDialog(null, "Suppression reussie","Ajout Achat", JOptionPane.INFORMATION_MESSAGE);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "Suppression annulée", "Suppression Achat", JOptionPane.INFORMATION_MESSAGE);
            
            }
        return 0;
    }
    
}
