package com.arka.mappers;

import com.arka.entities.client.Cliente;
import com.arka.tables.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    ClientEntityMapper INSTANCE = Mappers.getMapper(ClientEntityMapper.class);

    @Mapping(source = "celular", target = "telefono")
    @Mapping(target = "id", ignore = true)
    ClientEntity mapperDomainToEntity(Cliente cliente);

    @Mapping(source = "telefono", target = "celular")
    Cliente mapperEntityToDomain(ClientEntity clientEntity);

}
