package com.arka.service;

import com.arka.entities.Loan;
import com.arka.entities.Person;
import com.arka.gateways.loan.LoanGateway;
import com.arka.repository.CreditoRepository;
import com.arka.tables.CreditoEntity;
import com.arka.tables.PersonasEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreditoService implements LoanGateway {

    private final CreditoRepository creditoRepository;

    @Override
    public Loan save(Person person) {
        CreditoEntity creditoEntity = this.buildMapperDomainToEntity(person);
        CreditoEntity creditoEntitySave =  creditoRepository.save(creditoEntity);
       return this.buildMapperEntityToDomain(creditoEntitySave);
    }

    private Loan buildMapperEntityToDomain(CreditoEntity creditoEntitySave) {
        return Loan.
                builder()
                .id(creditoEntitySave.getId())
                .loanId(creditoEntitySave.getCreditoId())
                .create(creditoEntitySave.getFechaCreacion())
                .estado(creditoEntitySave.getEstado())
                .person(Person
                        .builder()
                        .firstName(creditoEntitySave.getPersona().getPrimerNombre())
                        .lastName(creditoEntitySave.getPersona().getPrimerApellido())
                        .build())
                .build();
    }

    private  CreditoEntity buildMapperDomainToEntity(Person person) {
       return CreditoEntity
                .builder()
                .creditoId(2L)
                .estado("APROBADO")
                .fechaCreacion(LocalDateTime.now())
                .persona(PersonasEntity
                        .builder()
                        .primerNombre(person.getFirstName())
                        .primerApellido(person.getLastName())
                        .build())
                .build();
    }
}
