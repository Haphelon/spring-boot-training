package com.csquared.incidents.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csquared.incidents.entities.Customer;
import com.csquared.incidents.services.CustomerService;

@RestController
@RequestMapping("customers")
@CrossOrigin(origins = "*")
public class IncidentController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<HashMap<String,String>> addCustomerDetails(@RequestBody Customer customer) {
        return customerService.addCustomerDetails(customer);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCustomers(){
        return customerService.getAllCustomers();
    }

}
