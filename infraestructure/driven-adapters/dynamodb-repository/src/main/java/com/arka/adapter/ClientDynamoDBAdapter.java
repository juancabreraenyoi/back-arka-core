package com.arka.adapter;

import com.arka.document.ClientDocument;
import com.arka.entities.client.Cliente;
import com.arka.gateways.client.ClientGateway;
import com.arka.mapper.ClientDocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Service
@RequiredArgsConstructor
public class ClientDynamoDBAdapter implements ClientGateway {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private final ClientDocumentMapper clientDocumentMapper;

    @Value("${aws.dynamodb.table.client:clientes}")
    private String tableName;

    @Override
    public Cliente save(Cliente cliente) {
        DynamoDbTable<ClientDocument> table = dynamoDbEnhancedClient.table(
                tableName,
                TableSchema.fromBean(ClientDocument.class)
        );

        ClientDocument clientDocument = clientDocumentMapper.mapperDomainToDocument(cliente);
        ClientDocument savedDocument = table.updateItem(clientDocument);

        return clientDocumentMapper.mapperDocumentToDomain(savedDocument);
    }
}
