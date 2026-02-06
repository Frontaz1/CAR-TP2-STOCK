package com.example.tp1.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client {

    @Id
    private String mail;

    private String mdp;
    private String nom;
    private String prenom;

    @OneToMany
    List<Commande> commandes;

    public Client(String mail, String mdp, String nom, String prenom) {
        this.mail = mail;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(){}


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public void addCommande(Commande commande){
        commandes.add(commande);
    }
}
