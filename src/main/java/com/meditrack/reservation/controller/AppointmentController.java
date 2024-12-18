// package com.meditrack.reservation.controller;

// import com.meditrack.reservation.model.entity.Appointment;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @Tag(name = "Appointment", description = "The Appointment API")
// @Slf4j
// @RequestMapping("/appointment")
// @Validated
// public class AppointmentController {

//     @GetMapping(produces = "application/json")
//     public ResponseEntity<Appointment> getAppointment() {
//         log.info("Get Appointment");
//         return ResponseEntity.ok(new Appointment());
//     }
// }
package com.meditrack.reservation.controller;

import com.meditrack.reservation.model.entity.Appointment;
import com.meditrack.reservation.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Appointment", description = "The Appointment API")
@Slf4j
@RequestMapping("/appointment")
@Validated
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        log.info("Get Appointment with ID: {}", id);
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
        log.info("Create Appointment: {}", appointment);
        return ResponseEntity.ok("Appointment created successfully");
    }
}
