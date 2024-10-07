package com.dev.vtu_api.vtuTest.controller;


import com.dev.vtu_api.vtu.service.VtuService;
import com.dev.vtu_api.vtu.controller.VtuController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    class VtuControllerTest {

        @Mock
        private VtuService vtuService;

        @InjectMocks
        private VtuController vtuController;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testPurchaseAirtime() throws Exception {
            String phoneNumber = "1234567890";
            double amount = 100.0;
            String expectedResponse = "{\"status\":\"success\"}";

            when(vtuService.purchaseAirtime(phoneNumber, amount)).thenReturn(expectedResponse);

            ResponseEntity<String> response = vtuController.purchaseAirtime(phoneNumber, amount);

            assertEquals(200, response.getStatusCodeValue());
            assertEquals(expectedResponse, response.getBody());
        }
    }


