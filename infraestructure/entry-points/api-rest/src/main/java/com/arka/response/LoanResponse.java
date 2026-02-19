package com.arka.response;


import com.arka.common.LoanCreate;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private String transactionId;
    private LocalDateTime transactionCreate;
    private LoanCreate loanCreate;

}
