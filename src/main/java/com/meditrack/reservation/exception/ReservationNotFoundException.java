package com.meditrack.reservation.exception;

import com.meditrack.reservation.constant.ErrorCode;
import lombok.Getter;

@Getter
public class ReservationNotFoundException extends Exception {
    private final ErrorCode errorCode;

    public ReservationNotFoundException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
