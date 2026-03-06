package br.com.coderbank.customerportal.dto.request;

import jakarta.transaction.Status;

import java.util.UUID;

public record ClientRequestDto(
        String name,
        String cpf,
        String email,
        String addres,
        Integer age
) {
}
