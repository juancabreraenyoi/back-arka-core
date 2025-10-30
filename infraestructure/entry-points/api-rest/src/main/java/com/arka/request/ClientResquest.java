package com.arka.request;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientResquest {
    private String nombre;
    private String apellido;
    private String telefono;
}