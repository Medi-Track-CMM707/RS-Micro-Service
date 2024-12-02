package com.meditrack.reservation.constant;

import lombok.Getter;

@Getter
public enum ErrorCode {
    RS_002001("Something went wrong, an error occurred in Exception"),
    RS_003001("Validation failed"),
    PRM_003002("Invalid request");

    private final String message;
    
    ErrorCode(String message) {
        this.message = message;
    }

}
