package com.arka.controller;


import com.arka.CreateLoanUseCase;
import com.arka.common.LoanCreate;
import com.arka.entities.Person;
import com.arka.request.LoanRequest;
import com.arka.response.LoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loan")
@RequiredArgsConstructor
public class LoanController {

    private final CreateLoanUseCase createLoanUseCase;

    @PostMapping("/create")
    public ResponseEntity<LoanResponse> createLoan(@RequestBody LoanRequest request){

        var person = Person.builder()
                .firstName(request.person().firstName())
                .lastName(request.person().lastName())
                .build();
        var loan = createLoanUseCase.execute(person);

        var loanCreate = LoanCreate.builder()
                .loanId(loan.getLoanId())
                .estado(loan.getEstado())
                .build();

        var loanResponse = LoanResponse.builder()
                .transactionId(request.transactionId())
                .transactionCreate(loan.getCreate())
                .loanCreate(loanCreate)
                .build();

       return ResponseEntity.ok(loanResponse);
    }

}
