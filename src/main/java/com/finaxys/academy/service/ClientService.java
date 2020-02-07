package com.finaxys.academy.service;


import com.finaxys.academy.entity.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ClientService {
   List<Client> getAllClients();
}
