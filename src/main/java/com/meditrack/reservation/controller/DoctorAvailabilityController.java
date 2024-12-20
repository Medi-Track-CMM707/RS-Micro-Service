
package com.meditrack.reservation.controller;

import com.meditrack.reservation.model.entity.DoctorAvailability;
import com.meditrack.reservation.service.DoctorAvailabilityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Doctor Availability", description = "The Doctor Availability API")
@Slf4j
@RequestMapping("/doctor-availabilities")
@Validated
public class DoctorAvailabilityController {

    @Autowired
    private DoctorAvailabilityService doctorAvailabilityService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<DoctorAvailability>> getAllDoctorAvailabilities() {
        log.info("Get all doctor availabilities");
        List<DoctorAvailability> availabilities = doctorAvailabilityService.getAllDoctorAvailabilities();
        return ResponseEntity.ok(availabilities);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DoctorAvailability> getDoctorAvailabilityById(@PathVariable Long id) {
        log.info("Get doctor availability by ID: {}", id);
        DoctorAvailability availability = doctorAvailabilityService.getDoctorAvailabilityById(id);
        return ResponseEntity.ok(availability);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<DoctorAvailability> addDoctorAvailability(@RequestBody DoctorAvailability availability) {
        log.info("Add new doctor availability");
        DoctorAvailability newAvailability = doctorAvailabilityService.addDoctorAvailability(availability);
        return ResponseEntity.ok(newAvailability);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DoctorAvailability> updateDoctorAvailability(@PathVariable Long id, @RequestBody DoctorAvailability availability) {
        log.info("Update doctor availability with ID: {}", id);
        DoctorAvailability updatedAvailability = doctorAvailabilityService.updateDoctorAvailability(id, availability);
        return ResponseEntity.ok(updatedAvailability);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDoctorAvailability(@PathVariable Long id) {
        log.info("Delete doctor availability with ID: {}", id);
        doctorAvailabilityService.deleteDoctorAvailability(id);
        return ResponseEntity.noContent().build();
    }
}
