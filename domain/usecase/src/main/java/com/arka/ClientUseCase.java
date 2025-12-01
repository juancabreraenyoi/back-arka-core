package com.arka;


import com.arka.entities.client.Cliente;
import com.arka.gateways.client.ClientGateway;
import com.arka.service.client.ClienteService;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class ClientUseCase {

    private final ClientGateway clientGateway;
    private final ClienteService clienteService;

    public Cliente execute(Cliente cliente){
        Cliente client  = (Cliente) clienteService.flowCreateClient(cliente);
       if (Objects.nonNull(client)){
           return clientGateway.save(client);
       }
       return Cliente.builder().build();
    }

}
