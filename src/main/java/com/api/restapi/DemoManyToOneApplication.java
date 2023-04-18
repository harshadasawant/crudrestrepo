package com.api.restapi;

import com.api.dto.CustomerDTO;
import com.api.dto.LoanDTO;
import com.api.service.CustomerLoanService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@ComponentScan(basePackages = "com.api")
@EnableJpaRepositories(
        basePackages = "com.api.repository")
@EntityScan(basePackages = "com.api.entity")
public class DemoManyToOneApplication implements CommandLineRunner {

    public static final Log LOGGER = LogFactory.getLog(DemoManyToOneApplication.class);
    @Autowired
    CustomerLoanService customerLoanService;
    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(DemoManyToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        getLoanDetails();
//        addLoanAndCustomer();
//		sanctionLoanToExistingCustomer();
//		closeLoan();
        deleteLoan();

    }

    public void getLoanDetails() {
        try {
            LoanDTO loanDTO = customerLoanService.getLoanDetails(1);
            LOGGER.info(loanDTO);
        } catch (Exception e) {
            String message = environment.getProperty(e.getMessage(), "Some exception occured. Please check log file for more details!!");
            LOGGER.info(message);
        }
    }
    public void addLoanAndCustomer() {
        try{
            LoanDTO loanDTO=new LoanDTO();
            loanDTO.setAmount(556279.0);
            loanDTO.setLoanIssueDate(LocalDate.of(2015, 11, 1));
            loanDTO.setStatus("Open");
            CustomerDTO customerDTO=new CustomerDTO();
            customerDTO.setCustomerId(1008);
            customerDTO.setDateOfBirth(LocalDate.of(1992, 1, 10));
            customerDTO.setEmailId("peter@hnd.com");
            customerDTO.setName("Peter");
            loanDTO.setCustomer(customerDTO);
            Integer loanId=customerLoanService.addLoanAndCustomer(loanDTO);
            LOGGER.info(environment.getProperty("UserInterface.NEW_LOAN_CUSTOMER_SUCCESS")+loanId);
        }catch(Exception e){
            String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
            LOGGER.info(message);
        }
    }
    public void sanctionLoanToExistingCustomer() {
        try{

            LoanDTO loanDTO=new LoanDTO();
            loanDTO.setAmount(573279.0);
            loanDTO.setLoanIssueDate(LocalDate.of(2013, 11, 1));
            loanDTO.setStatus("Open");
            Integer customerId=1007;
            customerLoanService.sanctionLoanToExistingCustomer(customerId, loanDTO);
            LOGGER.info(environment.getProperty("UserInterface.LOAN_SANCTION_SUCCESS"));
        }
        catch(Exception e){
            String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
            LOGGER.info(message);
        }
    }

    public void closeLoan() {
        try {
            Integer loanId=1;
            customerLoanService.closeLoan(loanId);
            LOGGER.info(environment.getProperty("UserInterface.LOAN_CLOSE_SUCCESS"));
        } catch (Exception e) {
            String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
            LOGGER.info(message);
        }
    }

    public void deleteLoan() {
        try {
        Integer loanId=1;
        customerLoanService.deleteLoan(loanId);
        LOGGER.info(environment.getProperty("UserInterface.LOAN_DELETE_SUCCESS"));
    } catch (Exception e) {
        String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
        LOGGER.info(message);
    }
    }

    }


