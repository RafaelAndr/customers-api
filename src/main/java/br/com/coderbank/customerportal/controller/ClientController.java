package br.com.coderbank.customerportal.controller;

import br.com.coderbank.customerportal.dto.response.ClientResponseDto;
import br.com.coderbank.customerportal.dto.request.ClientRequestDto;
import br.com.coderbank.customerportal.entity.Client;
import br.com.coderbank.customerportal.repository.ClientRepository;
import br.com.coderbank.customerportal.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponseDto> save(@RequestBody ClientRequestDto clientRequestDto){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(clientRequestDto));
    }


 }