/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Josué Dikoma
 */
public class Client {
    int  idClient;
    String nomsClient;
    String typeClient;
    String communeClient;
    String adresseClient;

    public Client() {
    }

    public Client(String nomsClient, String typeClient, String communeClient, String adresseClient) {
        this.nomsClient = nomsClient;
        this.typeClient = typeClient;
        this.communeClient = communeClient;
        this.adresseClient = adresseClient;
    }

    public Client(int idClient, String nomsClient, String typeClient, String communeClient, String adresseClient) {
        this.idClient = idClient;
        this.nomsClient = nomsClient;
        this.typeClient = typeClient;
        this.communeClient = communeClient;
        this.adresseClient = adresseClient;
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(int idClient, String nomsClient) {
        this.idClient = idClient;
        this.nomsClient = nomsClient;
    }

    public Client(String nomsClient) {
        this.nomsClient = nomsClient;
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomsClient() {
        return nomsClient;
    }

    public void setNomsClient(String nomsClient) {
        this.nomsClient = nomsClient;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getCommuneClient() {
        return communeClient;
    }

    public void setCommuneClient(String communeClient) {
        this.communeClient = communeClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }
    
    
    
    
    
}
