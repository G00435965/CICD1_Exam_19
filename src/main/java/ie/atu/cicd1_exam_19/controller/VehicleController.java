package ie.atu.cicd1_exam_19.controller;


import ie.atu.cicd1_exam_19.model.vehicle;
import ie.atu.cicd1_exam_19.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<vehicle>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{reg}")
    public ResponseEntity<vehicle> getOne(@PathVariable String reg) {
        Optional<vehicle> maybe = service.findByReg(reg);
        if(maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<vehicle> create(@Valid @RequestBody vehicle v) {
        vehicle created = service.create(v);
        return ResponseEntity
                .created(URI.create("/api/vehicle/" + created.getvehicleReg)))
        .body(created);
    }
}
