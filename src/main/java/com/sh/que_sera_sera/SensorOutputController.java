package com.sh.que_sera_sera;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sensor")
public class SensorOutputController {
    private final SensorOutputRepository sensorOutputRepository;

    private SensorOutputController(SensorOutputRepository sensorOutputRepository) {
        this.sensorOutputRepository = sensorOutputRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<SensorOutput> findById(@PathVariable Long requestedId) {
        Optional<SensorOutput> sensorOutputOptional = sensorOutputRepository.findById(requestedId);
        if (sensorOutputOptional.isPresent()) {
            return ResponseEntity.ok(sensorOutputOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
