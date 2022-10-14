package com.consumer.logger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer implements Serializable {
    public String name;
    public String lastName;
    public String rfc;
    public String curp;
    public String address;
    public String contactNumber;
    public String city;
    public String email;
}
