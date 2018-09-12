/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Achat;
import Entite.Produit;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Josué Dikoma
 */
public class Controller_Achat {
    static Dao.Dao_Achat daoAchat= new Dao.Dao_Achat();
    
    public static int enregistrer(JComboBox jc1, JTextField jt0,JComboBox jc2, JComboBox jc3, JTextField jt1, JTextField jt2, JTextField jt3)
    {
        Achat achat= new Achat();
        achat.setIdAchat(Integer.parseInt(jc1.getSelectedItem().toString()));
//        achat.setDateAchat(jt0.getText());
        Produit produit= new Produit(Integer.parseInt(jc2.getSelectedItem().toString()), jc3.getSelectedItem().toString());
        achat.setPrixunitaireAchat(Double.parseDouble(jt1.getText()));
        achat.setQuantiteAchat(Double.parseDouble(jt2.getText()));
        achat.setPrixtotalAchat(Double.parseDouble(jt3.getText()));
        return daoAchat.Enregistrer(achat);
    
    }
    public static int Supprimer(JComboBox jc1, JComboBox jc2, JComboBox jc3, JTextField jt1, JTextField jt2, JTextField jt3)
    {
        Achat achat= new Achat();
        achat.setIdAchat(Integer.parseInt(jc1.getSelectedItem().toString()));
        
        Produit produit= new Produit(Integer.parseInt(jc2.getSelectedItem().toString()), jc3.getSelectedItem().toString());
        achat.setPrixunitaireAchat(Double.parseDouble(jt1.getText()));
        achat.setQuantiteAchat(Double.parseDouble(jt2.getText()));
        achat.setPrixtotalAchat(Double.parseDouble(jt3.getText()));
        return daoAchat.Modifier(achat);
    }
    
    public static int Supprimer(JComboBox jc1)
    {
        Achat achat= new Achat();
        achat.setIdAchat(Integer.parseInt(jc1.getSelectedItem().toString()));
        return daoAchat.Supprimer(achat);
    }
    
    
}
