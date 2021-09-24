package com.felixin.test.web.rest;

import com.felixin.test.domain.FelixinNumber;
import com.felixin.test.security.model.JwtResponseModel;
import com.felixin.test.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RandomController {
    private final NumberService numberService;

    @PostMapping("/admin/generate")
    public ResponseEntity<Void> createRandomNumber() {
        numberService.createRandomNumber();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin/number")
    public ResponseEntity<List<FelixinNumber>> getRandomNumbers() {
        return ResponseEntity.ok(numberService.getRandomNumbers());
    }
}
