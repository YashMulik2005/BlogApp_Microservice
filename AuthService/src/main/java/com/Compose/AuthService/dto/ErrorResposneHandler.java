package com.Compose.AuthService.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResposneHandler {
    public static ResponseEntity<Object> errorResponseBuilder(HttpStatus httpStatus, boolean status,
                                                                String msg){
        Map<String,Object> res = new HashMap<>();
        res.put("status",status);
        res.put("message", msg);
        return new ResponseEntity<>(res,httpStatus);
    }
}
