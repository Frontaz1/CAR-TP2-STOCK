package com.example.tp1.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private long id;

    private String titre;

    @OneToMany
    List<Ligne> lignes;



    public Commande(String titre) {
        this.titre = titre;
    }

    public Commande(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(List<Ligne> lignes) {
        this.lignes = lignes;
    }

    public void addLigne(Ligne ligne){
        lignes.add(ligne);
    }
    public void deleteLigne(Ligne ligne){
        lignes.remove(ligne);
    }
}
