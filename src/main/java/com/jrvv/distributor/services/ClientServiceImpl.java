package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.Client;
import com.jrvv.distributor.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id).map(client -> {
            client.setCliNames(clientDetails.getCliNames());
            client.setCliLastNames(clientDetails.getCliLastNames());
            client.setCliDni(clientDetails.getCliDni());
            client.setCliCellphone(clientDetails.getCliCellphone());
            client.setCliWhatsapp(clientDetails.getCliWhatsapp());
            client.setCliEmail(clientDetails.getCliEmail());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
