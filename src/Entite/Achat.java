/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author Josué Dikoma
 */
public class Achat {
    int idAchat;
    Date dateAchat;
    Produit idProduit;
    Produit nomProduit;
    double prixunitaireAchat;
    double quantiteAchat;
    double prixtotalAchat;

    public Achat() {
    }

    public Achat(int idAchat) {
        this.idAchat = idAchat;
    }

    public Achat(Date dateAchat, Produit idProduit, Produit nomProduit, double prixunitaireAchat, double quantiteAchat, double prixtotalAchat) {
        this.dateAchat = dateAchat;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixunitaireAchat = prixunitaireAchat;
        this.quantiteAchat = quantiteAchat;
        this.prixtotalAchat = prixtotalAchat;
    }

    public Achat(int idAchat, Date dateAchat, Produit idProduit, Produit nomProduit, double prixunitaireAchat, double quantiteAchat, double prixtotalAchat) {
        this.idAchat = idAchat;
        this.dateAchat = dateAchat;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixunitaireAchat = prixunitaireAchat;
        this.quantiteAchat = quantiteAchat;
        this.prixtotalAchat = prixtotalAchat;
    }

    public int getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(int idAchat) {
        this.idAchat = idAchat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    public Produit getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(Produit nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixunitaireAchat() {
        return prixunitaireAchat;
    }

    public void setPrixunitaireAchat(double prixunitaireAchat) {
        this.prixunitaireAchat = prixunitaireAchat;
    }

    public double getQuantiteAchat() {
        return quantiteAchat;
    }

    public void setQuantiteAchat(double quantiteAchat) {
        this.quantiteAchat = quantiteAchat;
    }

    public double getPrixtotalAchat() {
        return prixtotalAchat;
    }

    public void setPrixtotalAchat(double prixtotalAchat) {
        this.prixtotalAchat = prixtotalAchat;
    }
    
    
    
    
    
    
}
