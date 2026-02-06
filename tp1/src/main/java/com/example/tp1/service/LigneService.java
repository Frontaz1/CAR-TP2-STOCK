package com.example.tp1.service;

import com.example.tp1.data.Commande;
import com.example.tp1.data.CommandeRepository;
import com.example.tp1.data.Ligne;
import com.example.tp1.data.LigneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneService {

    private LigneRepository ligneRepository;
    private CommandeRepository commandeRepository;

    public LigneService(LigneRepository ligneRepository, CommandeRepository commandeRepository) {
        this.ligneRepository = ligneRepository;
        this.commandeRepository = commandeRepository;
    }

    public void ajouterLigne(Long commandeId, String libelle, int qte, double prix) {
        Commande commande = commandeRepository.findById(commandeId).orElse(null);

        if (commande != null) {
            Ligne ligne = new Ligne(libelle, qte, prix);
            ligneRepository.save(ligne);
            commande.addLigne(ligne);
            commandeRepository.save(commande);
        }
    }

    public void supprimerLigne(Long commandeId, Long ligneId) {
        Commande commande = commandeRepository.findById(commandeId).orElse(null);
        Ligne ligne = ligneRepository.findById(ligneId).orElse(null);
        commande.deleteLigne(ligne);
        commandeRepository.save(commande);
        ligneRepository.deleteById(ligneId);

    }


}
