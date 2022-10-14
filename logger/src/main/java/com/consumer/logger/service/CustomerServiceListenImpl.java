package com.consumer.logger.service;

import com.consumer.logger.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableJms
public class CustomerServiceListenImpl {

    @JmsListener(destination = "${spring.activemq.destination}", containerFactory = "myfactory")
    public void receiveMessage(Customer customer){
        try {
            log.info("message recived" + customer);
        } catch (Exception e){
            log.error("Error "+ e);
        }
    }
}
