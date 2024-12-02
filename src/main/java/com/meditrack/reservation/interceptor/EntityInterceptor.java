package com.meditrack.reservation.interceptor;

import com.meditrack.reservation.model.entity.Base;
import com.meditrack.reservation.service.HeaderReadService;
import com.meditrack.reservation.util.ApplicationUtil;
import jakarta.persistence.PrePersist;

public class EntityInterceptor {

    @PrePersist
    public void beforePersist(Object entity) {
        // Manipulate the entity before saving
        if (entity instanceof Base baseEntity) {
            final HeaderReadService headerReadService = ApplicationUtil.getBean(HeaderReadService.class);
            baseEntity.setHospitalId(headerReadService.getHospitalId());
            baseEntity.setCreatedBy(headerReadService.getUser());
        }
    }
}
