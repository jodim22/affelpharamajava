/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Josué Dikoma
 */
public class Vente {
    int numVente;
    LocalDate dateVente;
    Produit idProduit;
    Produit nomProduit;
    double prixunitaireProduit;
    double quantiteProduit;
    double prixtotalProduit;

    public Vente() {
    }

    public Vente(int numVente) {
        this.numVente = numVente;
    }

    public Vente(LocalDate dateVente,Produit idProduit, Produit nomProduit, double prixunitaireProduit, double quantiteProduit, double prixtotalProduit) {
        this.dateVente=dateVente;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixunitaireProduit = prixunitaireProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixtotalProduit = prixtotalProduit;
    }

    public Vente(int numVente,LocalDate dateVente, Produit idProduit, Produit nomProduit, double prixunitaireProduit, double quantiteProduit, double prixtotalProduit) {
        this.numVente = numVente;
        this.dateVente=dateVente;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixunitaireProduit = prixunitaireProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixtotalProduit = prixtotalProduit;
    }

    public int getNumVente() {
        return numVente;
    }

    public LocalDate getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }

    public void setNumVente(int numVente) {
        this.numVente = numVente;
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

    public double getPrixunitaireProduit() {
        return prixunitaireProduit;
    }

    public void setPrixunitaireProduit(double prixunitaireProduit) {
        this.prixunitaireProduit = prixunitaireProduit;
    }

    public double getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(double quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public double getPrixtotalProduit() {
        return prixtotalProduit;
    }

    public void setPrixtotalProduit(double prixtotalProduit) {
        this.prixtotalProduit = prixtotalProduit;
    }
    
    
    
    
}
