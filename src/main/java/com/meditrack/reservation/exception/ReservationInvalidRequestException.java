package com.meditrack.reservation.exception;

import com.meditrack.reservation.constant.ErrorCode;
import lombok.Getter;

@Getter
public class ReservationInvalidRequestException extends Exception {
    private final ErrorCode errorCode;

    public ReservationInvalidRequestException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
