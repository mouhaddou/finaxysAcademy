package com.finaxys.academy.service;


import com.finaxys.academy.entity.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface ClientService {
   List<Client> getAllClients();
   void saveClient(Client client);
   void delete(Client client);
   Optional<Client> findById(Long id);
}
