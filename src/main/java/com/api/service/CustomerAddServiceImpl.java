package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.AddressDTO;
import com.api.dto.CustomerAddDTO;
import com.api.entity.Address;
import com.api.entity.CustomerAdd;
import com.api.repository.CustomerAddRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "customerAddService")
@Transactional
public class CustomerAddServiceImpl implements CustomerAddService {
    @Autowired
    private CustomerAddRepository customerRepository;
    @Override
    public CustomerAddDTO getCustomer(Integer customerId) throws HnDBankException {
        Optional<CustomerAdd> optional = customerRepository.findById(customerId);
        CustomerAdd customer = optional.orElseThrow(() -> new HnDBankException("Service.INVALID_CUSTOMERID"));
        CustomerAddDTO customerAddDTO = new CustomerAddDTO();
        customerAddDTO.setCustomerId(customer.getCustomerId());
        customerAddDTO.setName(customer.getName());
        customerAddDTO.setEmailId(customer.getEmailId());
        customerAddDTO.setDateOfBirth(customer.getDateOfBirth());
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(customer.getAddress().getAddressId());
        addressDTO.setCity(customer.getAddress().getCity());
        addressDTO.setStreet(customer.getAddress().getStreet());
        customerAddDTO.setAddress(addressDTO);
        return customerAddDTO;
    }
    @Override
    public Integer addCustomer(CustomerAddDTO customerDTO) {
        CustomerAdd customerAdd = new CustomerAdd();
        customerAdd.setCustomerId(customerDTO.getCustomerId());
        customerAdd.setDateOfBirth(customerDTO.getDateOfBirth());
        customerAdd.setEmailId(customerDTO.getEmailId());
        customerAdd.setName(customerDTO.getName());

        Address address = new Address();
        address.setAddressId(customerDTO.getAddress().getAddressId());
        address.setCity(customerDTO.getAddress().getCity());
        address.setStreet(customerDTO.getAddress().getStreet());

        customerAdd.setAddress(address);
        customerRepository.save(customerAdd);
        return customerAdd.getCustomerId();
    }
    @Override
    public void updateAddress(Integer customerId, AddressDTO addressDTO) throws HnDBankException {
        Optional<CustomerAdd> optional = customerRepository.findById(customerId);
        CustomerAdd customer = optional.orElseThrow(() -> new HnDBankException("Service.INVALID_CUSTOMERID"));
        Address address = customer.getAddress();
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
    }

    @Override
    public void deleteCustomer(Integer customerId) throws HnDBankException {
        Optional<CustomerAdd> optional = customerRepository.findById(customerId);
        CustomerAdd customer = optional.orElseThrow(() -> new HnDBankException("Service.INVALID_CUSTOMERID"));
        customerRepository.delete(customer);
    }
    @Override
    public void deleteCustomerOnly(Integer customerId) throws HnDBankException {
        Optional<CustomerAdd> optional = customerRepository.findById(customerId);
        CustomerAdd customer = optional.orElseThrow(() -> new HnDBankException("Service.INVALID_CUSTOMERID"));
        customer.setAddress(null);
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerAddDTO> findAll() throws HnDBankException {
        Iterable<CustomerAdd> customers = customerRepository.findAll();
        List<CustomerAddDTO> customerAddDTO = new ArrayList<>();
        customers.forEach(customer -> {
            CustomerAddDTO customerDto = new CustomerAddDTO();
            customerDto.setCustomerId(customer.getCustomerId());
            customerDto.setDateOfBirth(customer.getDateOfBirth());
            customerDto.setEmailId(customer.getEmailId());
            customerDto.setName(customer.getName());
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCity(customer.getAddress().getCity());
            addressDTO.setAddressId(customer.getAddress().getAddressId());
            addressDTO.setStreet(customer.getAddress().getStreet());
            customerDto.setAddress(addressDTO);
            customerAddDTO.add(customerDto);
        });
        if (customerAddDTO.isEmpty())
            throw new HnDBankException("Service.CUSTOMERS_NOT_FOUND");
        return customerAddDTO;
    }


}
