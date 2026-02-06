package com.example.tp1.service;

import com.example.tp1.data.Client;
import com.example.tp1.data.ClientRepository;
import com.example.tp1.data.Commande;
import com.example.tp1.data.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private CommandeRepository commandeRepository;
    private ClientRepository clientRepository;

    public CommandeService(CommandeRepository commandeRepository,ClientRepository clientRepository ){
        this.commandeRepository=commandeRepository;
        this.clientRepository=clientRepository;
    }


    public void createCommande(String titre, Client client) {
        Commande commande = new Commande(titre);
        commandeRepository.save(commande);
        client.addCommande(commande);
        clientRepository.save(client);
    }


    public Commande getCommandeById(Long id) { return commandeRepository.findById(id).orElse(null); }
}
