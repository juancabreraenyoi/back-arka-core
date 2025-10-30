package com.arka.controller;


import com.arka.ClientUseCase;
import com.arka.entities.client.Cliente;
import com.arka.mappers.ClientMapper;
import com.arka.request.ClientResquest;
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

    private static ClientUseCase clientUseCase;

    @PostMapping("/create")
    public ResponseEntity<ClientResponse> create(@RequestBody ClientResquest clientResquest){

        Cliente requestToDomain =  ClientMapper.requestToDomain(clientResquest);
        Cliente domainToResponse = clientUseCase.execute(requestToDomain);
        ClientResponse clientResponse = ClientMapper.domainToResponse(domainToResponse);

        return ResponseEntity.ok(clientResponse);
    }


}
