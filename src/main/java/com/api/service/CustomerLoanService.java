package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.LoanDTO;

public interface CustomerLoanService {
    public LoanDTO getLoanDetails(Integer loanId) throws HnDBankException;
    public Integer addLoanAndCustomer(LoanDTO loanDTO) throws HnDBankException;
    public Integer sanctionLoanToExistingCustomer(Integer customerId,LoanDTO loanDTO) throws HnDBankException;
    public void closeLoan(Integer loanId) throws HnDBankException;
    public void deleteLoan(Integer loanId) throws HnDBankException;
}
