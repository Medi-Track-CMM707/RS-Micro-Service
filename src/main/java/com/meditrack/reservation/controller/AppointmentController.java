package com.meditrack.reservation.controller;

import com.meditrack.reservation.model.entity.Appointment;
import com.meditrack.reservation.repository.AppointmentRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Appointment", description = "The Appointment API")
@Slf4j
@RequestMapping("/appointment")
@Validated
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Appointment> getAppointment() {
        log.info("Get Appointment");
        Appointment appointment = appointmentRepository.findById(1L).orElse(new Appointment());
        return ResponseEntity.ok(appointment);
    }
}
