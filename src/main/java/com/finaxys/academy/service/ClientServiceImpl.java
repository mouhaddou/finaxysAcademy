package com.finaxys.academy.service;

import com.finaxys.academy.dao.ClientRepository;
import com.finaxys.academy.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

   public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
    clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
    clientRepository.delete(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return  clientRepository.findById(id);
    }


}
