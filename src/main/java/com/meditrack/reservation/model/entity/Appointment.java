package com.meditrack.reservation.model.entity;

import com.meditrack.reservation.constant.APPOINTMENT_STATUS;
import com.meditrack.reservation.constant.APPOINTMENT_TYPE;
import com.meditrack.reservation.interceptor.EntityInterceptor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(EntityInterceptor.class)
public class Appointment extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long patientId;

    private Long doctorId;

    private Date appointmentDate;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    @Enumerated(EnumType.STRING)
    private APPOINTMENT_TYPE appointmentType;

    @Enumerated(EnumType.STRING)
    private APPOINTMENT_STATUS status = APPOINTMENT_STATUS.PENDING;

    @Column(length = 1000)
    private String reason;
}
