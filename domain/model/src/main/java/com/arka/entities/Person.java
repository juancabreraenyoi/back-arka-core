package com.arka.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
}
