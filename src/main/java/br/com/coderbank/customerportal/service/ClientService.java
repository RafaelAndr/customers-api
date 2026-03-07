package br.com.coderbank.customerportal.service;

import br.com.coderbank.customerportal.dto.request.ClientRequestDto;
import br.com.coderbank.customerportal.dto.response.ClientResponseDto;
import br.com.coderbank.customerportal.entity.Client;
import br.com.coderbank.customerportal.enuns.Status;
import br.com.coderbank.customerportal.exception.ClientAlreadyExistsException;
import br.com.coderbank.customerportal.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientResponseDto save(final ClientRequestDto clientRequestDto){
        checkDuplicatedCpf(clientRequestDto);
        var clientEntity = new Client();

        BeanUtils.copyProperties(clientRequestDto, clientEntity);

        clientEntity.setStatus(Status.ACTIVE);
        repository.save(clientEntity);

        return new ClientResponseDto(
                clientEntity.getId(),
                clientEntity.getStatus(),
                clientEntity.getCreatedByUser(),
                clientEntity.getCreatedDateAndTime(),
                clientEntity.getEditedByUser(),
                clientEntity.getEditedDateAndTime()
        );
    }

    private void checkDuplicatedCpf(final ClientRequestDto clientRequestDto){
        var clientCpf = clientRequestDto.cpf();

        if (repository.existsByCpf(clientCpf)) {
            throw new ClientAlreadyExistsException("Client with cpf " + clientCpf + " already exists");
        }
    }
}
