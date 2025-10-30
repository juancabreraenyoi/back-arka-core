package com.arka.entities.client;

import com.arka.entities.Persona;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Cliente extends Persona {
        private String celular;
        private boolean activo;

}
