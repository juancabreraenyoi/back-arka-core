package com.arka.mappers;

import com.arka.entities.client.Cliente;
import com.arka.request.ClientResquest;
import com.arka.response.ClientResponse;

public class ClientMapper {

    public static Cliente requestToDomain(ClientResquest clientResquest){
         return Cliente.builder()
                .nombre(clientResquest.getNombre())
                .apellido(clientResquest.getApellido())
                .celular(clientResquest.getTelefono())
                .activo(true)
                .build();
    }

    public static ClientResponse domainToResponse(Cliente cliente){
        return ClientResponse.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .build();
    }


}
