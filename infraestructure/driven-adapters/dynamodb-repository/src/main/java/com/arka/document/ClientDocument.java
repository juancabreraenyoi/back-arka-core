package com.arka.document;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDocument {

    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private boolean activo;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("nombre")
    public String getNombre() {
        return nombre;
    }

    @DynamoDbAttribute("apellido")
    public String getApellido() {
        return apellido;
    }

    @DynamoDbAttribute("telefono")
    public String getTelefono() {
        return telefono;
    }

    @DynamoDbAttribute("activo")
    public boolean isActivo() {
        return activo;
    }
}
