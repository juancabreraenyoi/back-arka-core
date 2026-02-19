package com.arka.entities;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private Long id;
    private LocalDateTime create;
    private Long loanId;
    private String estado;
    private Person person;
}
