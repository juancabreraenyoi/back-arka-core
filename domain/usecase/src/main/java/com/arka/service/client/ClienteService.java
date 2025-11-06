package com.arka.service.client;

import com.arka.entities.client.Cliente;
import com.arka.steps.client.ClientCountryCodeStep;

public class ClienteService {

    public Object flowCreateClient(Cliente cliente){
        String phoneCountryCode = ClientCountryCodeStep.concatCountryCode(cliente.getCelular());
        cliente.toBuilder()
                .celular(phoneCountryCode)
                .build();
        return cliente;
    }
}
