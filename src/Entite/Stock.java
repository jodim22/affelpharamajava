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
public class Stock {
    Produit idProduit;
    Produit libelleProduit;
    double Quantite;
    double PrixUnitaire;

    public Stock(Produit idProduit, Produit libelleProduit, double Quantite, double PrixUnitaire) {
        this.idProduit = idProduit;
        this.libelleProduit = libelleProduit;
        this.Quantite = Quantite;
        this.PrixUnitaire = PrixUnitaire;
    }

    public Stock() {
    }

    public Stock(double Quantite, double PrixUnitaire) {
        this.Quantite = Quantite;
        this.PrixUnitaire = PrixUnitaire;
    }

    public Stock(Produit idProduit, Produit libelleProduit) {
        this.idProduit = idProduit;
        this.libelleProduit = libelleProduit;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    public Produit getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(Produit libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public double getQuantite() {
        return Quantite;
    }

    public void setQuantite(double Quantite) {
        this.Quantite = Quantite;
    }

    public double getPrixUnitaire() {
        return PrixUnitaire;
    }

    public void setPrixUnitaire(double PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
    }
    
    
    
}
