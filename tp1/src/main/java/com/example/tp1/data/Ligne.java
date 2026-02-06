package com.example.tp1.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ligne {
    @Id
    @GeneratedValue
    private long id;

    private String libelle;
    private int quantite;
    private double prixUnitaire;



    public Ligne() {}

    public Ligne(String libelle, int quantite, double prixUnitaire) {
        this.libelle = libelle;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

}
