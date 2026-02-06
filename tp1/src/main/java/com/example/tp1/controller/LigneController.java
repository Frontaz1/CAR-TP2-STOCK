package com.example.tp1.controller;

import com.example.tp1.service.CommandeService;
import com.example.tp1.service.LigneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LigneController {

    private LigneService ligneService;


    public LigneController(LigneService ligneService) {
        this.ligneService = ligneService;

    }

    @PostMapping("/store/ligne/create")
    public RedirectView createLigne(@RequestParam Long commandeId, @RequestParam String libelle, @RequestParam int quantite, @RequestParam double prix) {

        ligneService.ajouterLigne(commandeId, libelle, quantite, prix);

        return new RedirectView("/store/commande/detail?commandeId=" + commandeId);
    }

    @GetMapping("/store/ligne/delete")
    public RedirectView deleteLigne(@RequestParam Long ligneId, @RequestParam Long commandeId) {
        ligneService.supprimerLigne(commandeId,ligneId);
        return new RedirectView("/store/commande/detail?commandeId=" + commandeId);
    }
}
