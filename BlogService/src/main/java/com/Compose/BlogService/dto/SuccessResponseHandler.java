package com.Compose.BlogService.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class SuccessResponseHandler {
    public static ResponseEntity<Object> successResponseBuilder(HttpStatus httpStatus, boolean status,
                                                                String msg, Object body){
        Map<String,Object> res = new HashMap<>();
        res.put("status",status);
        res.put("message", msg);
        res.put("data", body);
        return new ResponseEntity<>(res,httpStatus);
    }
}
