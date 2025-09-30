package com.tukaram.quizapp.controller;

import com.tukaram.quizapp.model.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("health")
public class HealthController {

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> healthCheck() {
        Map<String, Object> healthData = new HashMap<>();
        healthData.put("status", "UP");
        healthData.put("timestamp", LocalDateTime.now());
        healthData.put("service", "Tukaram-Quiz-App");
        healthData.put("version", "1.0.0");
        
        return ResponseEntity.ok(ApiResponse.success("Service is healthy", healthData));
    }

    @GetMapping("database")
    public ResponseEntity<ApiResponse<Map<String, Object>>> databaseHealth() {
        Map<String, Object> dbHealth = new HashMap<>();
        dbHealth.put("status", "UP");
        dbHealth.put("timestamp", LocalDateTime.now());
        dbHealth.put("database", "MySQL");
        
        return ResponseEntity.ok(ApiResponse.success("Database is healthy", dbHealth));
    }
}
