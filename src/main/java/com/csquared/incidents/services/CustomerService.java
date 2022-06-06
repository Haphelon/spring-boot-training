package com.csquared.incidents.services;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.BadRequestException;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;

import com.csquared.incidents.entities.Customer;
import com.csquared.incidents.exceptions.EmptyStringException;
import com.csquared.incidents.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<HashMap<String, String>> addCustomerDetails(Customer customer) {
        HashMap<String, String> response = new HashMap<>();
        try {

            if (Strings.isNullOrEmpty(customer.getName())) {
                throw new BadRequestException("Please provide the customer's name!");
            } else if (Strings.isNullOrEmpty(customer.getEmail())) {
                throw new BadRequestException("Please provide the customer's email!");
            }

            customer = customerRepository.save(customer);

            if (customer.isMale()) {
                response.put("message", "Hello Mr. " + customer.getName());
            } else if (customer.isFemale()) {
                response.put("message", "Hello Miss " + customer.getName());
            } else {
                response.put("message", "Hello " + customer.getName());
            }
            return ResponseEntity.ok().body(response);
        } catch (BadRequestException ex) {
            response.put("message", ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.put("message", "An error occured!");
            return ResponseEntity.internalServerError().body(response);
        }
    }

    public ResponseEntity<?> getAllCustomers() {
        try{
            List<Customer> customers = customerRepository.findAll();
            return ResponseEntity.ok().body(customers);
        }catch (Exception ex) {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "An error occured!");
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
