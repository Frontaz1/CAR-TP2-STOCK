package com.example.tp2.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ligne {
    @Id
    @GeneratedValue
    private long id;

    private String libelle;
    private int quantite;



    public Ligne() {}

    public Ligne(String libelle, int quantite) {
        this.libelle = libelle;
        this.quantite = quantite;
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

}
