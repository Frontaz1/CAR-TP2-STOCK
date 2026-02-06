package com.example.tp1.service;

import com.example.tp1.data.Client;
import com.example.tp1.data.ClientRepository;
import com.example.tp1.data.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public void createClient(String mail,String mdp, String nom, String prenom){
        var client = new Client(mail,mdp,nom,prenom);
        if(!clientRepository.existsById(client.getMail())){
            clientRepository.save(client);
        } else {
            //Afficher message client existe déjà
        }
    }

    public Iterable<Client> readAllClients(){
        return clientRepository.findAll();
    }

    public Client getClient(String mail) {
        return clientRepository.findByMail(mail);
    }
    public boolean login(String mail,String mdp){
        return clientRepository.existsByMailAndMdp(mail,mdp);
    }
    public List<Commande> getCommandeByIdClient(String mail){
        Client client = getClient(mail);
        return client.getCommandes();
    }
}
