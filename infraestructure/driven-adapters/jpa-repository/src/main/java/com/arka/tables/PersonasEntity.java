package com.arka.tables;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primerNombre;
    private String primerApellido;

    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CreditoEntity> creditos = new ArrayList<>();
}
