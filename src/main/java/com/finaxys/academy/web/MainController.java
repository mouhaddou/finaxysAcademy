package com.finaxys.academy.web;


import com.finaxys.academy.dao.ClientRepository;
import com.finaxys.academy.entity.Client;
import com.finaxys.academy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Client> getAll() {
        List<Client> all = clientService.getAllClients();
            return all;
    }
    // create a new employee
    @CrossOrigin
    @RequestMapping(value = "/createEmpl", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@RequestBody Client client){
        clientService.saveClient(client);
        return new ResponseEntity ("Emplyee created",HttpStatus.CREATED);
    }
    // delete employee by id
    @RequestMapping(value="deleteEmpl", method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteEmpl(@RequestBody Client client){
        clientService.delete(client);
        return new ResponseEntity("Employee : "+ client.getId()+ "is successfly deleted",HttpStatus.OK);
    }

    // update employee
    @RequestMapping(value="updateEmpl", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateEmpl(@RequestBody Client client){
       Optional <Client>  clientToUpdate = clientService.findById(client.getId());
        if(clientToUpdate.isPresent()){
            clientToUpdate.get().setDateOfBirth(client.getDateOfBirth());
            clientToUpdate.get().setFullName(client.getFullName());
            clientService.saveClient(clientToUpdate.get());
        }
        return new ResponseEntity("Employee : "+ client.getId()+ "has been successfly updated ",HttpStatus.OK);
    }
}