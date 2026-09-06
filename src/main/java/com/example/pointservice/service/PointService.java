package com.example.pointservice.service;

import com.example.pointservice.domain.Point;
import com.example.pointservice.domain.PointRepository;
import com.example.pointservice.dto.AddPointRequestsDto;
import com.example.pointservice.dto.DeductPointRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PointService {
    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Transactional
    public void addPoints(AddPointRequestsDto addPointRequestsDto) {
        Point point = pointRepository.findByUserId(addPointRequestsDto.getUserId())
                .orElseGet(() -> new Point(addPointRequestsDto.getUserId(), 0));

        point.addAmount(addPointRequestsDto.getAmount());

        pointRepository.save(point);
    }


    @Transactional
    public void deductPoints(DeductPointRequestDto deductPointRequestDto) {
        Point point = pointRepository.findByUserId(deductPointRequestDto.getUserId())
                .orElseGet(() -> new Point(deductPointRequestDto.getUserId(), 0));

        point.deductAmount(deductPointRequestDto.getAmount());

        pointRepository.save(point);
    }
}
