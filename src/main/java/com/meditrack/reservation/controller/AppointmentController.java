
package com.meditrack.reservation.controller;

import com.meditrack.reservation.model.entity.Appointment;
import com.meditrack.reservation.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Appointment", description = "The Appointment API")
@Slf4j
@RequestMapping("/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        log.info("Get all appointments");
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        log.info("Get appointment by ID: {}", id);
        Appointment appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        log.info("Add new appointment");
        Appointment newAppointment = appointmentService.addAppointment(appointment);
        return ResponseEntity.ok(newAppointment);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        log.info("Update appointment with ID: {}", id);
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        log.info("Delete appointment with ID: {}", id);
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}


// package com.meditrack.reservation.controller;

// import com.meditrack.reservation.model.entity.Appointment;
// import com.meditrack.reservation.repository.AppointmentRepository;
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

//     private final AppointmentRepository appointmentRepository;

//     public AppointmentController(AppointmentRepository appointmentRepository) {
//         this.appointmentRepository = appointmentRepository;
//     }

//     @GetMapping(produces = "application/json")
//     public ResponseEntity<Appointment> getAppointment() {
//         log.info("Get Appointment");
//         Appointment appointment = appointmentRepository.findById(1L).orElse(new Appointment());
//         return ResponseEntity.ok(appointment);
//     }
// }
