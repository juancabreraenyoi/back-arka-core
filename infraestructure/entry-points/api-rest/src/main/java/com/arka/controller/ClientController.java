package com.arka.controller;


import com.arka.ClientUseCase;
import com.arka.entities.client.Cliente;
import com.arka.mappers.mapstruct.ClientMappers;
import com.arka.request.ClientRequest;
import com.arka.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientUseCase clientUseCase;
    private final ClientMappers clientMappers;

    @PostMapping("/create")
    public ResponseEntity<ClientResponse> create(@RequestBody ClientRequest clientResquest){
        /**
         *   Mapeo desde Resquest to Domain y Domain Response sin libreria con llamado estatico a los metodos
          */
//        Cliente requestToDomain =  ClientMapper.requestToDomain(clientResquest);
//        Cliente domainToResponse = ClientUseCase.execute(requestToDomain);
//        ClientResponse clientResponse = ClientMapper.domainToResponse(domainToResponse);

        /**
         *   Mapeo desde Resquest to Domain y Domain Response con libreria libreria con inyecion de dependencias
          */

        Cliente requestToDomain =  clientMappers.mapperRequestToDomain(clientResquest);
        Cliente domainToResponse = clientUseCase.execute(requestToDomain);
        ClientResponse clientResponse = clientMappers.mapperDomainToResponse(domainToResponse);

        return ResponseEntity.ok(clientResponse);
    }


}
