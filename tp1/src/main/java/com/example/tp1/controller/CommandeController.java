package com.example.tp1.controller;

import com.example.tp1.data.Client;
import com.example.tp1.data.ClientRepository;
import com.example.tp1.data.Commande;
import com.example.tp1.data.Ligne;
import com.example.tp1.service.ClientService;
import com.example.tp1.service.CommandeService;
import com.example.tp1.service.LigneService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
@Controller
public class CommandeController {

    private CommandeService commandeService;

    private LigneService ligneService;

    private ClientService clientService;
    public CommandeController(CommandeService commandeService, LigneService ligneService,ClientService clientService) {
        this.commandeService = commandeService;
        this.ligneService = ligneService;
        this.clientService = clientService;
    }

    @GetMapping("/store/commande")
    public ModelAndView commande(HttpSession session) {
        String mail = (String) session.getAttribute("idClientConnecte");

        if (mail == null) {
            return new ModelAndView("redirect:/store/home");
        }
        Client client = clientService.getClient(mail);
        return new ModelAndView("commande", Map.of("client", client, "commandes", client.getCommandes()));
    }

    @PostMapping("/store/commande/create")
    public RedirectView createCommande(@RequestParam String titre, HttpSession session) {
        String mail = (String) session.getAttribute("idClientConnecte");
        Client client = clientService.getClient(mail);
        commandeService.createCommande(titre,client);
        return new RedirectView("/store/commande");
    }

    @GetMapping("/store/commande/detail")
    public ModelAndView detailCommande(@RequestParam Long commandeId, HttpSession session) {
        String mail = (String) session.getAttribute("idClientConnecte");
        Client client = clientService.getClient(mail);
        if (mail == null) {
            return new ModelAndView("redirect:/store/home");
        }
        Commande commande = commandeService.getCommandeById(commandeId);
        List<Ligne> lignes = commande.getLignes();

        return new ModelAndView("detail", Map.of("commande", commande, "lignes", lignes));
    }

    @GetMapping("/store/commande/print")
    public ModelAndView printCommande(@RequestParam Long commandeId, HttpSession session) {
        String mail = (String) session.getAttribute("idClientConnecte");
        Client client = clientService.getClient(mail);
        if (mail == null) {
            return new ModelAndView("redirect:/store/home");
        }
        Commande commande = commandeService.getCommandeById(commandeId);
        List<Ligne> lignes = commande.getLignes();

        var model = Map.of("client", client, "commande", commande, "lignes", lignes);

        return new ModelAndView("print", model);
    }
}
