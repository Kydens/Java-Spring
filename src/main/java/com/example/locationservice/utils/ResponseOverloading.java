package com.example.locationservice.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public class ResponseOverloading {

    // jika tidak membutuhkan data
    public ResponseEntity<Object> apiResponse(String status, Integer statusCode, String message) {
        Map<String, Object> bodyResponse = new LinkedHashMap<>();
        bodyResponse.put("status", status);
        bodyResponse.put("statusCode", statusCode);
        bodyResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(bodyResponse);
    }

    // jika membutuhkan data
    public ResponseEntity<Object> apiResponse(String status, Integer statusCode, String message, Object data) {
        Map<String, Object> bodyResponse = new LinkedHashMap<>();
        bodyResponse.put("status", status);
        bodyResponse.put("statusCode", statusCode);
        bodyResponse.put("message", message);
        bodyResponse.put("data", data);
        return ResponseEntity.status(statusCode).body(bodyResponse);
    }
}
