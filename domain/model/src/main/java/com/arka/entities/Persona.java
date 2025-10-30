package com.arka.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Persona {
    private String nombre;
    private String apellido;

}
