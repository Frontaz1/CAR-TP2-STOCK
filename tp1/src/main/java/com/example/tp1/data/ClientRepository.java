package com.example.tp1.data;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {

    boolean existsByMailAndMdp( String mail, String mdp );
    Client findByMail(String mail);

}
