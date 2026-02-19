package com.arka.gateways.loan;

import com.arka.entities.Loan;
import com.arka.entities.Person;

public interface LoanGateway {

    Loan save(Person person);
}
