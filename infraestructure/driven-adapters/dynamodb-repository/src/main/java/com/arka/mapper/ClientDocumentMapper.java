package com.arka.mapper;

import com.arka.document.ClientDocument;
import com.arka.entities.client.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ClientDocumentMapper {

    ClientDocumentMapper INSTANCE = Mappers.getMapper(ClientDocumentMapper.class);

    @Mapping(target = "id", expression = "java(generateId())")
    @Mapping(source = "celular", target = "telefono")
    ClientDocument mapperDomainToDocument(Cliente cliente);

    @Mapping(source = "telefono", target = "celular")
    Cliente mapperDocumentToDomain(ClientDocument clientDocument);

    default String generateId() {
        return UUID.randomUUID().toString();
    }
}
