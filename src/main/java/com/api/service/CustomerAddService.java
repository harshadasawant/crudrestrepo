package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.AddressDTO;
import com.api.dto.CustomerAddDTO;


import java.util.List;

public interface CustomerAddService {
    public CustomerAddDTO getCustomer(Integer customerId) throws HnDBankException;
    public Integer addCustomer(CustomerAddDTO customerDTO) throws HnDBankException;
    public void updateAddress(Integer customerId, AddressDTO addressDTO) throws HnDBankException;
    public void deleteCustomer(Integer customerId) throws HnDBankException;
    public void deleteCustomerOnly(Integer customerId) throws HnDBankException;
    public List<CustomerAddDTO> findAll() throws HnDBankException;
}
