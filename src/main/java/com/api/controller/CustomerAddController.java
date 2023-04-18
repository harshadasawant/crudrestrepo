package com.api.controller;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomerAddDTO;
import com.api.service.CustomerAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hndbank")
public class CustomerAddController {
    @Autowired
    CustomerAddService customerAddService;

    @GetMapping(value = "/customersAdd")
    public ResponseEntity<List<CustomerAddDTO>> getAllCustomers() throws HnDBankException {
        List<CustomerAddDTO> customerAddList = customerAddService.findAll();
        return new ResponseEntity<>(customerAddList, HttpStatus.OK);
    }

}
