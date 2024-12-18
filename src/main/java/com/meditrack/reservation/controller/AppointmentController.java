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

    // GET endpoint to retrieve an appointment
    @GetMapping(produces = "application/json")
    public ResponseEntity<Appointment> getAppointment() {
        log.info("Get Appointment");
        return ResponseEntity.ok(new Appointment());
    }

    // POST endpoint to create a new appointment
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
        log.info("Create Appointment: {}", appointment);
        // Business logic for saving the appointment can be added here.
        return ResponseEntity.ok("Appointment created successfully");
    }
}
