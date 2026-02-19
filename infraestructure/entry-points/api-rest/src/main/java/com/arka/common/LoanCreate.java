package com.arka.common;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanCreate {

        private Long loanId;
        private String estado;

}
