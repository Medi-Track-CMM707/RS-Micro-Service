
package com.meditrack.reservation.controller;

import com.meditrack.reservation.model.entity.Clinic;
import com.meditrack.reservation.service.ClinicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Clinic", description = "The Clinic API")
@Slf4j
@RequestMapping("/clinics")
@Validated
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Clinic>> getAllClinics() {
        log.info("Get all clinics");
        List<Clinic> clinics = clinicService.getAllClinics();
        return ResponseEntity.ok(clinics);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Clinic> getClinicById(@PathVariable Long id) {
        log.info("Get clinic by ID: {}", id);
        Clinic clinic = clinicService.getClinicById(id);
        return ResponseEntity.ok(clinic);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Clinic> addClinic(@RequestBody Clinic clinic) {
        log.info("Add new clinic");
        Clinic newClinic = clinicService.addClinic(clinic);
        return ResponseEntity.ok(newClinic);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Clinic> updateClinic(@PathVariable Long id, @RequestBody Clinic clinic) {
        log.info("Update clinic with ID: {}", id);
        Clinic updatedClinic = clinicService.updateClinic(id, clinic);
        return ResponseEntity.ok(updatedClinic);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable Long id) {
        log.info("Delete clinic with ID: {}", id);
        clinicService.deleteClinic(id);
        return ResponseEntity.noContent().build();
    }
}