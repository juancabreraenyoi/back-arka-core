package com.arka.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String nombre;
    private String apellido;
    private String telefono;
}