package com.shop.tomford.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String error;
    public Map<String, String> errors;


}
