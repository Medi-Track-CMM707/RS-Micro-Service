package com.meditrack.aggregator.controller;

import com.meditrack.reservation.service.AggregatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final AggregatorService aggregatorService;

    public ReportController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Data Aggregation Service is up and running!");
    }

    @GetMapping("/appointments-per-doctor")
    public ResponseEntity<List<Object[]>> getAppointmentsPerDoctor() {
        List<Object[]> results = aggregatorService.aggregateAppointmentsPerDoctor();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/appointment-frequency")
    public ResponseEntity<List<Object[]>> getAppointmentFrequency() {
        List<Object[]> results = aggregatorService.aggregateAppointmentFrequency();
        return ResponseEntity.ok(results);
    }
}
