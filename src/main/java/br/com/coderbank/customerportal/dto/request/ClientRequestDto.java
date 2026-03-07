package br.com.coderbank.customerportal.dto.request;

import jakarta.transaction.Status;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDto(
        @NotBlank(message = "Campo obrigatório")
        String name,
        @NotBlank(message = "Campo obrigatório")
        String cpf,
        String email,
        String addres,
        Integer age
) {
}
