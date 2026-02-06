package com.example.tp2.data;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LigneStockRepository extends CrudRepository<Ligne, Long> {
    Optional<Ligne> findByLibelle(String libelle);
}
