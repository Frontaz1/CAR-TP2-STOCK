package com.example.tp2.service;

import com.example.tp2.data.Ligne;
import com.example.tp2.data.LigneStockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    private LigneStockRepository ligneStockRepository;

    public StockService(LigneStockRepository ligneStockRepository){
        this.ligneStockRepository= ligneStockRepository;
    }
    public void addStock() {
        UpsertStock("table", 5);
        UpsertStock("chaise", 2);
    }
    public void UpsertStock(String libelle, int quantiteAjoutee) {
        Optional<Ligne> optionalLigne = ligneStockRepository.findByLibelle(libelle);

        if (optionalLigne.isPresent()) {
            Ligne ligne = optionalLigne.get();
            ligne.setQuantite(ligne.getQuantite() + quantiteAjoutee);
            ligneStockRepository.save(ligne);
        } else {
            Ligne nouvelleLigne = new Ligne(libelle, quantiteAjoutee);
            ligneStockRepository.save(nouvelleLigne);
        }
    }
    public Iterable<Ligne> getAllStock() {
        return ligneStockRepository.findAll();
    }

    public void DeleteStock(String libelle, int quantiteAjoutee) {
        Optional<Ligne> optionalLigne = ligneStockRepository.findByLibelle(libelle);

        if (optionalLigne.isPresent()) {
            Ligne ligne = optionalLigne.get();
            ligne.setQuantite(ligne.getQuantite() - quantiteAjoutee);
            ligneStockRepository.save(ligne);
        }
    }

}
