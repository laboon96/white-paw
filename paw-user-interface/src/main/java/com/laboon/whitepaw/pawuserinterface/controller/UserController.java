package com.laboon.whitepaw.pawuserinterface.controller;

import com.laboon.whitepaw.pawcommon.response.ApiResponse;
import com.laboon.whitepaw.pawcommon.response.ApiSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @GetMapping
    public ResponseEntity<ApiResponse> getAllUser() {
        return ResponseEntity.ok(ApiSuccessResponse.of("Test"));
    }
}
