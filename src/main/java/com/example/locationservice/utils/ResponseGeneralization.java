package com.example.locationservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGeneralization<T> {
    private String status;
    private Integer statusCode;
    private String message;
    private T data;
}
