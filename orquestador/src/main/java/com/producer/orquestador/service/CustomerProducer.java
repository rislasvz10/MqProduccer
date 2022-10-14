package com.producer.orquestador.service;

import com.producer.orquestador.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableJms
public class CustomerProducer {


    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${spring.activemq.destination}")
    private String destino;

    public void sendTextMessage(Customer customer){
        log.info("Intentando enviar el objeto: " );
        try {
            jmsTemplate.convertAndSend(destino, customer);
            log.info("Customer send....."+customer);
        } catch (Exception e){
            log.error("Error to send "+ e);
        }
    }


}
