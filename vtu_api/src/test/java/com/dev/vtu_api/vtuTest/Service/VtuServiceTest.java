package com.dev.vtu_api.vtuTest.Service;


import com.dev.vtu_api.vtu.service.VtuService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VtuServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private VtuService vtuService;

    public VtuServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPurchaseAirtime() {
        // Arrange
        String phoneNumber = "1234567890";
        double amount = 100.0;
        String expectedResponse = "{\"status\":\"success\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer your_api_key");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(Map.of("phoneNumber", phoneNumber, "amount", amount), headers);

        when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
                .thenReturn(ResponseEntity.ok(expectedResponse));

        String actualResponse = vtuService.purchaseAirtime(phoneNumber, amount);

        assertEquals(expectedResponse, actualResponse);
    }
}

