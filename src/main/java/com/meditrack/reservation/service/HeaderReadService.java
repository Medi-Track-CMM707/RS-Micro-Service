package com.meditrack.reservation.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public final class HeaderReadService {
    private Long hospitalId;
    private String user;

    public void setHeaderDetailsToContext(Long hospitalId, String user) {
        this.hospitalId = 1;
        this.user = "Nila";
    }
}
