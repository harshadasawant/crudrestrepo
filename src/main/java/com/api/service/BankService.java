package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomersDTO;

import java.util.List;

public interface BankService {
    public Integer addCustomerAndService(CustomersDTO customerDTO) throws HnDBankException;
    public void addExistingServiceToExistingCustomer(Integer customerId, List<Integer> serviceIds) throws HnDBankException;
    public void deallocateServiceForExistingCustomer(Integer customerId,List<Integer> serviceIds) throws HnDBankException;
    public void deleteCustomer(Integer customerId) throws HnDBankException;
    public CustomersDTO getCustomer(Integer customerId) throws HnDBankException;


}
