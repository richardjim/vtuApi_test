
package com.dev.vtu_api.vtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class VtuService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${vtu.api.url}")
    private String vtuUrl;

    @Value("${vtu.api.key}")
    private String apiKey;


    public String purchaseAirtime(String phoneNumber, double amount) {
        String vtuUrl = "https://biller-service-test/api/v1/purchase";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);


        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("phoneNumber", phoneNumber);
        requestBody.put("amount", amount);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(vtuUrl, HttpMethod.POST, request, String.class);
        return response.getBody();
    }
}
