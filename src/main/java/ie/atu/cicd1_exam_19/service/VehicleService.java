package ie.atu.cicd1_exam_19.service;


import ie.atu.cicd1_exam_19.model.vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final List<vehicle> store = new ArrayList<>();

    {
        for (vehicle v : store) {
            if (v.getregNumber().equals(reg)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    public vehicle create(vehicle v) {
        if (findByReg(v.getvehicleReg()).isPresent()) {
            throw new IllegalArgumentException("vehicleReg already exists");
        }
        store.add(v);
        return v;
    }
    public Optional<vehicle> update(String reg, vehicle updated) {
        for (vehicle v : store) {
            if (v.getvehicleReg().equals(reg)) {
                v.setName(updated.getdriverName());
                v.setEmail(updated.getEmail());
                return Optional.of(v);
            }
        }
        return Optional.empty(); }
    public boolean deleteByReg(String reg) {
        return store.removeIf(v -> v.getvehicleReg().equals(reg));
    }
}
