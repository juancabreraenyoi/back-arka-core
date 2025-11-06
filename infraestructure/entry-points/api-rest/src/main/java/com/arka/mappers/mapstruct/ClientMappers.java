package com.arka.mappers.mapstruct;

import com.arka.entities.client.Cliente;
import com.arka.request.ClientRequest;
import com.arka.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMappers {

    ClientMappers INSTANCEClientMappers = Mappers.getMapper(ClientMappers.class);


    // Request -> Domain
    @Mapping(source = "telefono",target = "celular")
    @Mapping(target = "activo", constant = "true")
    Cliente mapperRequestToDomain(ClientRequest clientResquest);


    // Domain -> Response
    ClientResponse mapperDomainToResponse(Cliente cliente);


}
