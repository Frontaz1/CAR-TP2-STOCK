package com.example.tp1.controller;

import com.example.tp1.data.Client;
import com.example.tp1.service.ClientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/store/home")
    public ModelAndView home(){
        var clients=clientService.readAllClients();
        var model = Map.of("clients",clients);
        return new ModelAndView("home",model);
    }

    @PostMapping("/client/create")
    public RedirectView createAuteur(@RequestParam String mail, @RequestParam String mdp, @RequestParam String nom, @RequestParam String prenom){
        clientService.createClient(mail,mdp,nom,prenom);
        return new RedirectView("/store/home");
    }

    @PostMapping("/client/login")
    public RedirectView login(@RequestParam String mail, @RequestParam String mdp, HttpSession session){
        if(clientService.login(mail, mdp)){
                session.setAttribute("idClientConnecte",mail);
                return new RedirectView("/store/commande");
        }
        return new RedirectView("/store/home");
    }

    @GetMapping("/store/disconnect")
    public RedirectView disconnect(HttpSession session){
        session.removeAttribute("idClientConnecte");
        return new RedirectView("/store/home");
    }
}
