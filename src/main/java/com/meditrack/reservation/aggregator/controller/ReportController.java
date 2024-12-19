package com.meditrack.aggregator.controller;

import com.meditrack.aggregator.service.AggregationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final AggregationService aggregationService;

    public ReportController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Data Aggregation Service is up and running!");
    }
}
