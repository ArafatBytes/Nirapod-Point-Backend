package com.nirapodpoint.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@RestController
public class HealthController {
    
    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        logger.info("Health check endpoint called");
        return ResponseEntity.ok(Map.of("status", "UP", "message", "Application is running"));
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> root() {
        logger.info("Root endpoint called");
        return ResponseEntity.ok(Map.of("message", "Nirapod Point Backend API", "status", "running"));
    }
    
    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        logger.info("Test endpoint called");
        return ResponseEntity.ok(Map.of("message", "Test endpoint working", "status", "success"));
    }
} 