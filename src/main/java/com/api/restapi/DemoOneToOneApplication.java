//package com.api.restapi;
//
//
//import com.api.dto.AddressDTO;
//import com.api.dto.CustomerAddDTO;
//import com.api.service.CustomerAddService;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import java.time.LocalDate;
//
//@SpringBootApplication
//@ComponentScan(basePackages = "com.api")
//@EnableJpaRepositories(
//        basePackages = "com.api.repository")
//@EntityScan(basePackages = "com.api.entity")
//public class DemoOneToOneApplication implements CommandLineRunner {
//
//    public static final Log LOGGER = LogFactory.getLog(DemoOneToOneApplication.class);
//    @Autowired
//    CustomerAddService customerService;
//    @Autowired
//    Environment environment;
//    public static void main(String[] args) {
//        SpringApplication.run(DemoOneToOneApplication.class, args);
//    }
//    @Override
//    public void run(String... args) throws Exception {
////        getCustomer();
//        addCustomer();
////        updateAddress();
////        deleteCustomer();
////        deleteCustomerOnly();
//    }
//
//    public void getCustomer() {
//        try {
//            CustomerAddDTO customerDTO = customerService.getCustomer(4);
//            LOGGER.info(customerDTO);
//        } catch (Exception e) {
//            String message = environment.getProperty(e.getMessage(), "Some exception occured. Please check log file for more details!!");
//            LOGGER.info(message);
//        }
//    }
//    public void addCustomer() {
//        try {
//            CustomerAddDTO customerDTO = new CustomerAddDTO();
//            customerDTO.setName("Roni");
//            customerDTO.setEmailId("roni@hnd.com");
//            customerDTO.setDateOfBirth(LocalDate.of(1993, 03, 24));
//            AddressDTO addressDTO = new AddressDTO();
//            addressDTO.setAddressId(104L);
//            addressDTO.setCity("mumbai");
//            addressDTO.setStreet("90 feet Road1");
//            customerDTO.setAddress(addressDTO);
//            Integer customerId = customerService.addCustomer(customerDTO);
//            LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_ADDED") + customerId);
//        } catch (Exception e) {
//            String message = environment.getProperty(e.getMessage(),"Some exception occurred. Please check log file for more details!!");
//            LOGGER.info(message);
//        }
//    }
//    public void updateAddress() {
//        try {
//            AddressDTO addressDTO = new AddressDTO();
//            addressDTO.setCity("Rochester");
//            addressDTO.setStreet("12 Tim Street");
//            customerService.updateAddress(4, addressDTO);
//            LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_UPDATED"));
//        } catch (Exception e) {
//            String message = environment.getProperty(e.getMessage(), "Some exception occurred. Please check log file for more details!!");
//            LOGGER.info(message);
//        }
//    }
//    public void deleteCustomer() {
//        try {
//            customerService.deleteCustomer(4);
//            LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_ADDRESS_DELETED"));
//        } catch (Exception e) {
//            String message = environment.getProperty(e.getMessage(), "Some exception occured. Please check log file for more details!!");
//            LOGGER.info(message);
//        }
//    }
//    public void deleteCustomerOnly() {
//        try {
//            customerService.deleteCustomerOnly(5);
//            LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_DELETED"));
//        } catch (Exception e) {
//            String message = environment.getProperty(e.getMessage(),
//                    "Some exception occured. Please check log file for more details!!");
//            LOGGER.info(message);
//        }
//    }
//
//
//}