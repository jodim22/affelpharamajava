/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Vente;
import Entite.Produit;
import Entite.Vente;
import com.toedter.calendar.JDateChooser;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
/**
 *
 * @author Josué Dikoma
 */
public class Controller_Vente {
    static Dao.Dao_Vente daoVente= new  Dao_Vente();
    
    public static int Enregistrer(JDateChooser jt1, JComboBox jc2, JComboBox jc3,JTextField jt2, JTextField jt3) throws ParseException
    {
        Vente vente= new Vente();
//        DateFormat df= new SimpleDateFormat();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//       vente.setNumVente(Integer.parseInt(jc1.getSelectedItem().toString()));
//        vente.setDateVente(df.parse(jt1.getText()));
        Date date_vente= jt1.getDate();
        ZoneId znid=ZoneId.systemDefault();
        LocalDate dateVente= date_vente.toInstant().atZone(znid).toLocalDate();
       // vente.setDateVente((jt1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
     //   vente.setDateVente(jt1.);
          vente.setDateVente(dateVente); 
        Produit produit= new Produit(Integer.parseInt(jc2.getSelectedItem().toString()));
        Produit produit2= new Produit(jc3.getSelectedItem().toString());
        vente.setIdProduit(produit);
        vente.setNomProduit(produit2);
        vente.setPrixunitaireProduit(Double.parseDouble(jt2.getText()));
        vente.setQuantiteProduit(Double.parseDouble(jt3.getText()));
        System.out.println(vente.getNomProduit().getLibelleProduit()+" " + vente.getDateVente().toString() +" "+ vente.getIdProduit().getIdProduit() +" "+ vente.getPrixtotalProduit() +" "+vente.getPrixunitaireProduit());
        return daoVente.Enregistrer(vente);
    }
    public static int Modifier(JComboBox jc1,JDateChooser jt1, JComboBox jc2, JComboBox jc3,JTextField jt2, JTextField jt3) throws ParseException
    {
        Vente vente= new Vente();
  //      DateFormat df= new SimpleDateFormat();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        vente.setNumVente(Integer.parseInt(jc1.getSelectedItem().toString()));
       // vente.setDateVente(jt1.getDate());
       //vente.setDateVente(jt1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        Date date_vente= jt1.getDate();
        ZoneId znid=ZoneId.systemDefault();
        LocalDate dateVente= date_vente.toInstant().atZone(znid).toLocalDate();
        vente.setDateVente(dateVente);
        Produit produit= new Produit(Integer.parseInt(jc2.getSelectedItem().toString()));
        Produit produit2= new Produit(jc3.getSelectedItem().toString());
        vente.setIdProduit(produit);
        vente.setNomProduit(produit2);
        vente.setPrixunitaireProduit(Double.parseDouble(jt2.getText()));
        vente.setQuantiteProduit(Double.parseDouble(jt3.getText()));
        return daoVente.Modifier(vente);
    
    }
    public static int Supprimer(JComboBox jc1)
    {
        Vente vente= new Vente();
        vente.setNumVente(Integer.parseInt(jc1.getSelectedItem().toString()));
        return daoVente.Supprimer(vente);
    }
         public static void Remplir(JTable tab,JComboBox jc0,JDateChooser jd ,JComboBox jc1, JComboBox jc2, JTextField jt1,JTextField jt2)
    {
        try {
            int index=tab.getSelectedRow();
            jc0.setSelectedItem(tab.getValueAt(index, 0));
            Date date= new SimpleDateFormat("yyyy-MM-dd").parse(tab.getValueAt(index, 1).toString());
            jd.setDate(date);
            jc1.setSelectedItem(tab.getValueAt(index, 2));
            jc2.setSelectedItem(tab.getValueAt(index, 3).toString());
            jt1.setText(tab.getValueAt(index, 4).toString());
            jt2.setText(tab.getValueAt(index, 5).toString());                        
        } catch (ParseException ex) {
            Logger.getLogger(Controller_Vente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
