package com.meditrack.reservation.model.dto;

public record ErrorResponseDTO(String errorCode, String errorMessage, Object additionalInformation) {

}

