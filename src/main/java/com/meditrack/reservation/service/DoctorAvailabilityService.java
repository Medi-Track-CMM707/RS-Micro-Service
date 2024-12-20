package com.meditrack.reservation.service;

import com.meditrack.reservation.model.entity.DoctorAvailability;
import com.meditrack.reservation.repository.DoctorAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorAvailabilityService {

    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    public List<DoctorAvailability> getAllDoctorAvailabilities() {
        return doctorAvailabilityRepository.findAll();
    }

    public DoctorAvailability getDoctorAvailabilityById(Long id) {
        return doctorAvailabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor availability not found"));
    }

    public DoctorAvailability addDoctorAvailability(DoctorAvailability availability) {
        return doctorAvailabilityRepository.save(availability);
    }

    public DoctorAvailability updateDoctorAvailability(Long id, DoctorAvailability availability) {
        DoctorAvailability existingAvailability = getDoctorAvailabilityById(id);
        existingAvailability.setDoctorId(availability.getDoctorId());
        existingAvailability.setDate(availability.getDate());
        existingAvailability.setStartTime(availability.getStartTime());
        existingAvailability.setEndTime(availability.getEndTime());
        existingAvailability.setStatus(availability.getStatus());
        existingAvailability.setComments(availability.getComments());
        return doctorAvailabilityRepository.save(existingAvailability);
    }

    public void deleteDoctorAvailability(Long id) {
        doctorAvailabilityRepository.deleteById(id);
    }
}
