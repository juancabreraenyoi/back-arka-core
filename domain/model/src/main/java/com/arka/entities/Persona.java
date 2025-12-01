package com.arka.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class Persona {
    private String nombre;
    private String apellido;

}
