/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_User;
import Entite.User;
import View.Register;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Josué Dik
 */
public class Controller_User {
    static Dao.Dao_User daoUser=new Dao_User();
    public static int Enregistrer(JTextField nomUser, JTextField postUser, JTextField typeUser,JTextField emailUser,JTextField loginUser, JPasswordField passUser)
    {
        
        User user= new User();
        user.setNomUser(nomUser.getText());
        user.setPostnomUser(postUser.getText());
        user.setTypeUser(typeUser.getText());
        user.setEmailuser(emailUser.getText());
        user.setLoginUser(loginUser.getText());
        user.setPassUser(passUser.getText());
        return daoUser.Enregistrer(user); 
    }
      public static int Enregistrer2(JComboBox jt1,JTextField nomUser, JTextField postUser, JComboBox typeUser,JTextField emailUser,JTextField loginUser, JTextField passUser)
    {
        
        User user= new User();
        user.setIdUser(Integer.parseInt(jt1.getSelectedItem().toString()));
        user.setNomUser(nomUser.getText());
        user.setPostnomUser(postUser.getText());
        user.setTypeUser(typeUser.getSelectedItem().toString());
        user.setEmailuser(emailUser.getText());
        user.setLoginUser(loginUser.getText()); 
        user.setPassUser(passUser.getText());
        return daoUser.Enregistrer(user); 
    }
    
      public static int Modifier(JComboBox jt1,JTextField nomUser, JTextField postUser, JTextField typeUser,JTextField emailUser,JTextField loginUser, JPasswordField passUser)
    {
        
        User user= new User();
        user.setIdUser(Integer.parseInt(jt1.getSelectedItem().toString()));
        user.setNomUser(nomUser.getText());
        user.setPostnomUser(postUser.getText());
        user.setTypeUser(typeUser.getText());
        user.setEmailuser(emailUser.getText());
        user.setLoginUser(loginUser.getText());
        user.setPassUser(passUser.getText());
        return daoUser.Modifier(user); 
    }
         public static int Modifier2(JComboBox jt1,JTextField nomUser, JTextField postUser, JComboBox typeUser,JTextField emailUser,JTextField loginUser, JTextField passUser)
    {
        
        User user= new User();
        user.setIdUser(Integer.parseInt(jt1.getSelectedItem().toString()));
        user.setNomUser(nomUser.getText());
        user.setPostnomUser(postUser.getText());
        user.setTypeUser(typeUser.getSelectedItem().toString());
        user.setEmailuser(emailUser.getText());
        user.setLoginUser(loginUser.getText());
        user.setPassUser(passUser.getText());
        return daoUser.Modifier(user); 
    }
       public static int Supprimer(JComboBox jt1)
    {
        
        User user= new User();
        user.setIdUser(Integer.parseInt(jt1.getSelectedItem().toString()));
        return daoUser.Supprimer(user); 
    }
      
    public static void Netoyer(JTextField jt1, JTextField jt2, JTextField jt3, JTextField jt4, JTextField jt5, JPasswordField jt6, JPasswordField jt7)
    {
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");
            jt4.setText("");
            jt5.setText("");
            jt6.setText("");
            jt7.setText("");
    }
    public static int confirmerMP(JPasswordField jt1, JPasswordField jt2)
    {
        String a=jt1.getText();
        String b=jt2.getText();
        if (a == null ? b == null : a.equals(b)) {
            
            return 1;
        }
        return 0;
    }
    public static int VerifierChamps(JTextField jt1, JTextField jt2, JTextField jt3, JTextField jt4, JTextField jt5, JPasswordField jt6, JPasswordField jt7)
    {
            if (jt1.getText()=="" ||jt2.getText()=="" || jt3.getText()=="" || jt4.getText()=="" || jt5.getText()=="" || jt6.getText()=="" || jt7.getText()=="" ) {
            JOptionPane.showMessageDialog(null, "Remplir les champs");
            return 0;
        }
    return 1;
    }
        public static void Remplir(JTable tab, JComboBox jc1, JTextField jt1, JTextField jt2, JComboBox jc2,  JTextField jt3, JTextField jt4, JTextField jt5)
    {
            User user= new User();
            int index=tab.getSelectedRow();
            user.setIdUser(Integer.parseInt(tab.getValueAt(index, 0).toString()));
            user.setNomUser(tab.getValueAt(index, 1).toString());
            user.setPostnomUser(tab.getValueAt(index, 2).toString());
            user.setTypeUser(tab.getValueAt(index, 3).toString());
            user.setEmailuser(tab.getValueAt(index, 4).toString());
            user.setLoginUser(tab.getValueAt(index, 5).toString());
            user.setPassUser(tab.getValueAt(index, 6).toString());
           
            jc1.setSelectedItem(user.getIdUser());
            jt1.setText(user.getNomUser());
            jt2.setText(user.getPostnomUser());
            jc2.setSelectedItem(user.getTypeUser());
            jt3.setText(user.getEmailuser());
            jt4.setText(user.getLoginUser());
            jt5.setText(user.getPassUser());
                             
    }
}
