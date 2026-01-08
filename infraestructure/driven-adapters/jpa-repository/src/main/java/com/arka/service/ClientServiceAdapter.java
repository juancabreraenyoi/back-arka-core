package com.arka.service;

import com.arka.entities.client.Cliente;
import com.arka.gateways.client.ClientGateway;
import com.arka.mappers.ClientEntityMapper;
import com.arka.repository.ClientRepository;
import com.arka.tables.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceAdapter implements ClientGateway {

    private final ClientRepository clientRepository;
    private  final ClientEntityMapper clientEntityMapper;


    @Override
    public Cliente save(Cliente cliente) {
       ClientEntity clientEntity =  clientEntityMapper.mapperDomainToEntity(cliente);
       ClientEntity clientSaved = clientRepository.save(clientEntity);
       return clientEntityMapper.mapperEntityToDomain(clientSaved);
    }



}
