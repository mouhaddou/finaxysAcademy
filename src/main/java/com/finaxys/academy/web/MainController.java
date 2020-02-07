package com.finaxys.academy.web;


import com.finaxys.academy.dao.ClientRepository;
import com.finaxys.academy.entity.Client;
import com.finaxys.academy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @ResponseBody
    @RequestMapping("/")
    public ResponseEntity getAll() {
        List<Client> all = clientService.getAllClients();
        if(!all.isEmpty()) {
            return new ResponseEntity(all, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("There is no client in the store.",HttpStatus.OK);
        }


    }

}