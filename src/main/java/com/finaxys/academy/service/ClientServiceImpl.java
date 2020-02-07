package com.finaxys.academy.service;

import com.finaxys.academy.dao.ClientRepository;
import com.finaxys.academy.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

   public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
}
