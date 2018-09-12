/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao_Client;
import Entite.Client;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Josué Dikoma
 */
public class Controller_Client {
    static Dao.Dao_Client daoClient= new Dao_Client();
    public static int Enregistrer(JComboBox jt1, JTextField  jt2,JComboBox jt3, JComboBox jt4, JTextField jt5)
    {
           Client client= new Client();
           client.setIdClient(Integer.parseInt(jt1.getSelectedItem().toString()));
           client.setNomsClient(jt2.getText());
           client.setTypeClient(jt3.getSelectedItem().toString());
           client.setCommuneClient(jt4.getSelectedItem().toString());
           client.setAdresseClient(jt5.getText());
           return daoClient.Enregistrer(client);
    }
    public static int Modifier(JComboBox jt1, JTextField  jt2,JComboBox jt3, JComboBox jt4, JTextField jt5)
    {
        Client client= new Client();
           client.setIdClient(Integer.parseInt(jt1.getSelectedItem().toString()));
           client.setNomsClient(jt2.getText());
           client.setTypeClient(jt3.getSelectedItem().toString());
           client.setCommuneClient(jt4.getSelectedItem().toString());
           client.setAdresseClient(jt5.getText());
           return daoClient.Modifier(client);
    }
    public static int Supprimer(JComboBox jt1)
    {
        Client client=new  Client();
        client.setIdClient(Integer.parseInt(jt1.getSelectedItem().toString()));
        return daoClient.Supprimer(client);
    }
      public static void Remplir(JTable tab, JComboBox jc1, JTextField jt1, JComboBox jc2, JComboBox jc3, JTextField jt2)
    {
            Client client= new Client();
            int index=tab.getSelectedRow();
            client.setIdClient(Integer.parseInt(tab.getValueAt(index, 0).toString()));
            client.setNomsClient(tab.getValueAt(index, 1).toString());
            client.setTypeClient(tab.getValueAt(index, 2).toString());
            client.setCommuneClient(tab.getValueAt(index, 3).toString());
            client.setAdresseClient(tab.getValueAt(index, 4).toString());
            
            jc1.setSelectedItem(client.getIdClient());
            jt1.setText(client.getNomsClient());
            jc2.setSelectedItem(client.getTypeClient());
            jc3.setSelectedItem(client.getCommuneClient());
            jt2.setText(client.getAdresseClient());         
    }
       public static int VerifierChamp(JTextField jt1,JTextField jt2)
       {
            if (jt1.getText().length()==0 || jt1.getText().length()==0) {
            return 0;
        }
        else{
       return 1;
        }
       }
}
