package com.example.pointservice.controller;

import com.example.pointservice.dto.DeductPointRequestDto;
import com.example.pointservice.dto.AddPointRequestsDto;
import com.example.pointservice.service.PointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/points")
public class PointnternalController {

    private final PointService pointService;

    public PointnternalController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("add")
    public ResponseEntity<Void> addPoints(
            @RequestBody AddPointRequestsDto addPointRequestsDto
    ) {
        pointService.addPoints(addPointRequestsDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("deduct")
    public ResponseEntity<Void> deductPoints(
            @RequestBody DeductPointRequestDto deductPointRequestDto
    ) {
        pointService.deductPoints(deductPointRequestDto);
        return ResponseEntity.noContent().build();
    }
}
