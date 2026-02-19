package com.arka.request;



import com.arka.common.Person;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record LoanRequest(String transactionId,LocalDateTime transactionCreate,Person person) {

}
