package com.godstime.HRMS.app.controller;


import com.godstime.HRMS.app.entities.Position;
import com.godstime.HRMS.app.exceptions.PositionCreationFailedException;
import com.godstime.HRMS.app.exceptions.PositionDeletionFailedException;
import com.godstime.HRMS.app.exceptions.PositionNotFoundException;
import com.godstime.HRMS.app.exceptions.PositionUpdateFailedException;
import com.godstime.HRMS.app.services.PositionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/positions")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/create")
    public ResponseEntity<Position> createPosition(@Valid @RequestBody Position position) {
        try {
            return ResponseEntity.ok(positionService.createPosition(position));
        } catch (Exception e) {
            throw new PositionCreationFailedException("Position creation failed: " + e.getMessage());
        }
    }

    @PutMapping("/update/{positionId}")
    public ResponseEntity<Position> updatePosition(@PathVariable Long positionId, @Valid @RequestBody Position position) {
        try {
            return ResponseEntity.ok(positionService.updatePosition(positionId, position));
        } catch (Exception e) {
            throw new PositionUpdateFailedException("Position update failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{positionId}")
    public ResponseEntity<String> deletePosition(@PathVariable Long positionId) {
        try {
            positionService.deletePosition(positionId);
            return ResponseEntity.ok("Position with ID " + positionId + " deleted successfully");
        } catch (Exception e) {
            throw new PositionDeletionFailedException("Position deletion failed: " + e.getMessage());
        }
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<Position> getPositionById(@PathVariable Long positionId) {
        try {
            return ResponseEntity.ok(positionService.getPositionById(positionId));
        } catch (Exception e) {
            throw new PositionNotFoundException("Position with ID " + positionId + " not found: " + e.getMessage());
        }
    }
}
