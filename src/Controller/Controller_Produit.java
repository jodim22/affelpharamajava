/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Produit;
import Entite.Produit;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Josué Dikoma
 */
public class Controller_Produit {
    static Dao.Dao_Produit daoProduit= new Dao_Produit();
    public static int Enregistrer (JComboBox jt1, JTextField jt2, JTextField jt3, JComboBox jt4, JComboBox jt5, JTextField jt6, JTextField jt7)
    {
        Produit produit= new Produit();
        produit.setIdProduit(Integer.parseInt(jt1.getSelectedItem().toString()));
        produit.setLibelleProduit(jt2.getText());
        produit.setNomScientifique(jt3.getText());
        produit.setTypeProduit(jt4.getSelectedItem().toString());
        produit.setEmballageProduit(jt5.getSelectedItem().toString());
        produit.setDoseProduit(jt6.getText());
        produit.setFabriquantProduit(jt7.getText());
        return daoProduit.Enregistrer(produit);
    }
    public static int Modifier(JComboBox jt1, JTextField jt2, JTextField jt3, JComboBox jt4, JComboBox jt5, JTextField jt6, JTextField jt7)
    {
        Produit produit= new Produit();
        produit.setIdProduit(Integer.parseInt(jt1.getSelectedItem().toString()));
        produit.setLibelleProduit(jt2.getText());
        produit.setNomScientifique(jt3.getText());
        produit.setTypeProduit(jt4.getSelectedItem().toString());
        produit.setEmballageProduit(jt5.getSelectedItem().toString());
        produit.setDoseProduit(jt6.getText());
        produit.setFabriquantProduit(jt7.getText());
        return daoProduit.Modifier(produit);
    
    }
    public static int Supprimer(JComboBox jt1)
    {
        Produit produit= new Produit();
        produit.setIdProduit(Integer.parseInt(jt1.getSelectedItem().toString()));
        return daoProduit.Supprimer(produit);
    }
    public static void Remplir(JTable tab, JComboBox jc1, JTextField jt1, JTextField jt2, JComboBox jc2, JComboBox jc3, JTextField jt3, JTextField jt4)
    {
            Produit produit=new Produit();          
            int index=tab.getSelectedRow();
            produit.setIdProduit(Integer.parseInt(tab.getValueAt(index, 0).toString()));
            produit.setLibelleProduit(tab.getValueAt(index, 1).toString());
            produit.setNomScientifique(tab.getValueAt(index, 2).toString());
            produit.setTypeProduit(tab.getValueAt(index, 3).toString());
            produit.setEmballageProduit(tab.getValueAt(index, 4).toString());
            produit.setDoseProduit(tab.getValueAt(index, 5).toString());
            produit.setFabriquantProduit(tab.getValueAt(index, 6).toString());
            
            jc1.setSelectedItem((produit.getIdProduit()));
            jt1.setText(produit.getLibelleProduit());
            jt2.setText(produit.getNomScientifique());
            jc2.setSelectedItem(produit.getTypeProduit());
            jc3.setSelectedItem(produit.getEmballageProduit());
            jt3.setText(produit.getDoseProduit());
            jt4.setText(produit.getFabriquantProduit());                    
    }
    
}
