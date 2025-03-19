package edu.uth.childvaccinesystem.controllers;

import edu.uth.childvaccinesystem.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<Map<String, Long>> getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("userCount", dashboardService.getUserCount());
        stats.put("appointmentCount", dashboardService.getAppointmentCount());
        stats.put("vaccineCount", dashboardService.getVaccineCount());
        return ResponseEntity.ok(stats);
    }
}
