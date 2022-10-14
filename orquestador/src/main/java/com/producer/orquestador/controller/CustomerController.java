package com.producer.orquestador.controller;

import com.producer.orquestador.model.Customer;
import com.producer.orquestador.service.CustomerProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerProducer customerProducer;

    @PostMapping("/customer")
    public ResponseEntity<String> sendMessage(@RequestBody Customer customer){
        customerProducer.sendTextMessage(customer);
        return new ResponseEntity<>("Message send...", HttpStatus.OK);
    }


}
