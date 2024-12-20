package com.meditrack.reservation.service;

import com.meditrack.reservation.repository.AppointmentRepository;
import com.meditrack.reservation.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AggregatorService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Scheduled(cron = "0 0 0 * * ?") // This runs daily at midnight
    public void aggregateData() {
        log.info("Starting data aggregation job...");

        aggregateAppointmentsPerDoctor();
        aggregateAppointmentFrequency();

        log.info("Data aggregation job completed.");
    }

    public List<Object[]> aggregateAppointmentsPerDoctor() {
        return appointmentRepository.countAppointmentsPerDoctor();
    }

    public List<Object[]> aggregateAppointmentFrequency() {
        return appointmentRepository.countAppointmentsOverTime();
    }

}

