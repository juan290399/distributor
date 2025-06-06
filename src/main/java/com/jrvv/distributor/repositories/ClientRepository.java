package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByCliNamesContainingIgnoreCase(String names);
    List<Client> findByCliLastNamesContainingIgnoreCase(String lastNames);
    List<Client> findByCliDni(String dni);
    List<Client> findByCliCellphone(String cellphone);
    List<Client> findByCliWhatsapp(String whatsapp);
    List<Client> findByCliEmailContainingIgnoreCase(String email);
}
