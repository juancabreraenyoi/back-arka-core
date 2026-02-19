package com.arka;

import com.arka.entities.Loan;
import com.arka.entities.Person;
import com.arka.gateways.loan.LoanGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateLoanUseCase {

    private LoanGateway loanGateway;

    public Loan execute(Person person){
        return loanGateway.save(person);
    }

}
