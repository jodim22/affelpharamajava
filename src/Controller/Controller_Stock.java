/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Stock;
import Entite.Produit;
import Entite.Stock;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Josué Dikoma
 */
public class Controller_Stock {
    
    static Dao_Stock daoStock=new Dao_Stock();
    public static int Enregister(JComboBox jc1,JComboBox jc2,JTextField jt1, JTextField jt2)
    {
        Stock stock= new Stock();
        
        
        Produit prod= new Produit(Integer.parseInt(jc1.getSelectedItem().toString()));
        Produit produit=new Produit(jc2.getSelectedItem().toString());
        stock.setQuantite(Double.parseDouble(jt1.getText()));
        stock.setPrixUnitaire(Double.parseDouble(jt2.getText()));
        stock.setIdProduit(prod);
        stock.setLibelleProduit(produit);
        return daoStock.Enregistrer(stock);
    }
    
    public static int Modifier(JComboBox jc1,JComboBox jc2,JTextField jt1, JTextField jt2)
    {
        Stock stock= new Stock();
        Produit prod= new Produit(Integer.parseInt(jc1.getSelectedItem().toString()));
        Produit produit=new Produit(jc2.getSelectedItem().toString());
        stock.setQuantite(Double.parseDouble(jt1.getText()));
        stock.setPrixUnitaire(Double.parseDouble(jt2.getText()));
        stock.setIdProduit(prod);
        stock.setLibelleProduit(produit);
        return daoStock.Modifier(stock);
    }
    public static int Supprimer(JComboBox jc1)
    {
        Stock stock= new Stock();
        Produit prod= new Produit(Integer.parseInt(jc1.getSelectedItem().toString()));
        stock.setIdProduit(prod);
        return daoStock.Supprimer(stock);
    }
    
       public static void Remplir(JTable tab, JComboBox jc1, JComboBox jc2, JTextField jt1,JTextField jt2)
    {
            int index=tab.getSelectedRow();
            jc1.setSelectedItem(tab.getValueAt(index, 0));
            jc2.setSelectedItem(tab.getValueAt(index, 1).toString());
            jt1.setText(tab.getValueAt(index, 2).toString());
            jt2.setText(tab.getValueAt(index, 3).toString());                        
    }
    public static int VerifierChamps(JTextField jt1, JTextField jt2)
    {
        if (jt1.getText().length()==0 || jt2.getText().length()==0) {
            return 0;
        }
        else{
       return 1;
        }
    }
}
