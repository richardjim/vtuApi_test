package com.dev.vtu_api.vtu.controller;


import com.dev.vtu_api.vtu.service.VtuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/v1/vtu")
    public class VtuController {

        @Autowired
        private VtuService vtuService;

        @PostMapping("/purchase")
        public ResponseEntity<String> purchaseAirtime(@RequestParam String phoneNumber, @RequestParam double amount) {
            String response = vtuService.purchaseAirtime(phoneNumber, amount);
            return ResponseEntity.ok(response);
        }
    }


