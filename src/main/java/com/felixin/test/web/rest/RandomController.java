package com.felixin.test.web.rest;

import com.felixin.test.security.model.JwtResponseModel;
import com.felixin.test.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RandomController {
    private final NumberService numberService;

    @PostMapping("/admin/generate")
    public ResponseEntity<Void> createRandomNumber() {
        numberService.createRandomNumber();
        return ResponseEntity.noContent().build();
    }
}
