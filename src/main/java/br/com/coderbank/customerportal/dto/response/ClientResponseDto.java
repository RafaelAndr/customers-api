package br.com.coderbank.customerportal.dto.response;


import br.com.coderbank.customerportal.entity.enuns.Status;

import java.util.UUID;

public record ClientResponseDto(
        UUID id,
        Status status,
        String createdByUser,
        String createdDateAndTime,
        String editedByUser,
        String editedDateAndTime
) {
}
