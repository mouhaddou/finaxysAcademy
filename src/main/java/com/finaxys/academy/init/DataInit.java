package com.finaxys.academy.init;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.finaxys.academy.dao.ClientRepository;
import com.finaxys.academy.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private ClientRepository clientRepository;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(ClientRepository clientDAO) {
        this.clientRepository = clientDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = clientRepository.count();

        if (count == 0) {
            Client p1 = new Client();

            p1.setFullName("John");

            Date d1 = df.parse("1980-12-20");
            p1.setDateOfBirth(d1);
            //
            Client p2 = new Client();

            p2.setFullName("Smith");
            Date d2 = df.parse("1985-11-11");
            p2.setDateOfBirth(d2);

            clientRepository.save(p1);
            clientRepository.save(p2);
        }

    }

}