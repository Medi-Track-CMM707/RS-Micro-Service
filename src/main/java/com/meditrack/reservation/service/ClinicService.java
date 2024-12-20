package com.meditrack.reservation.service;

import com.meditrack.reservation.model.entity.Clinic;
import com.meditrack.reservation.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
    }

    public Clinic addClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public Clinic updateClinic(Long id, Clinic clinic) {
        Clinic existingClinic = getClinicById(id);
        existingClinic.setName(clinic.getName());
        existingClinic.setLocation(clinic.getLocation());
        existingClinic.setNotes(clinic.getNotes());
        return clinicRepository.save(existingClinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }
}
