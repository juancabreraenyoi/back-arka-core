package com.arka.tables;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "credito")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion;
    private String estado;
    private Long creditoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private PersonasEntity persona;

}
