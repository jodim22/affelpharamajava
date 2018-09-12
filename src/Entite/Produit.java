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
public class Produit {
    int    idProduit;
    String libelleProduit;
    String nomScientifique;
    String typeProduit;
    String emballageProduit;
    String doseProduit;
    String fabriquantProduit;

    public Produit() {
    }

    public Produit(int idProduit, String libelleProduit, String nomScientifique, String typeProduit,String emballageProduit, String doseProduit, String fabriquantProduit) {
        this.idProduit = idProduit;
        this.libelleProduit = libelleProduit;
        this.nomScientifique = nomScientifique;
        this.typeProduit = typeProduit;
        this.emballageProduit=emballageProduit;
        this.doseProduit=doseProduit;
        this.fabriquantProduit=fabriquantProduit;
    }

    public Produit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public Produit(int idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(int idProduit, String libelleProduit) {
        this.idProduit = idProduit;
        this.libelleProduit = libelleProduit;
    }

    public Produit(String libelleProduit, String nomScientifique, String typeProduit, String emballageProduit,String doseProduit, String fabriquantProduit) {
        this.libelleProduit = libelleProduit;
        this.nomScientifique = nomScientifique;
        this.typeProduit = typeProduit;
        this.emballageProduit=emballageProduit;
        this.doseProduit=doseProduit;
        this.fabriquantProduit=fabriquantProduit;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getDoseProduit() {
        return doseProduit;
    }

    public void setDoseProduit(String doseProduit) {
        this.doseProduit = doseProduit;
    }

    public String getFabriquantProduit() {
        return fabriquantProduit;
    }

    public void setFabriquantProduit(String fabriquantProduit) {
        this.fabriquantProduit = fabriquantProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public String getNomScientifique() {
        return nomScientifique;
    }

    public void setNomScientifique(String nomScientifique) {
        this.nomScientifique = nomScientifique;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getEmballageProduit() {
        return emballageProduit;
    }

    public void setEmballageProduit(String emballageProduit) {
        this.emballageProduit = emballageProduit;
    }
    
    
    
    
}
