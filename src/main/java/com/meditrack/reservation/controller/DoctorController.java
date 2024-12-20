
package com.meditrack.reservation.controller;

import com.meditrack.reservation.model.entity.Doctor;
import com.meditrack.reservation.service.DoctorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Doctor", description = "The Doctor API")
@Slf4j
@RequestMapping("/doctors")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        log.info("Get all doctors");
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        log.info("Get doctor by ID: {}", id);
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        log.info("Add new doctor");
        Doctor newDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(newDoctor);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        log.info("Update doctor with ID: {}", id);
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        log.info("Delete doctor with ID: {}", id);
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
