package automated.tests.controllers;

import automated.tests.entities.HealthUnit;
import automated.tests.exceptions.ResourceNotFoundException;
import automated.tests.services.HealthUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health-units")
public class HealthUnitController {

    @Autowired
    private HealthUnitService healthUnitService;

    @GetMapping
    public List<HealthUnit> getAllHealthUnits() {
        return healthUnitService.getAllHealthUnits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthUnit> getHealthUnitById(@PathVariable Long id) {
        return healthUnitService.getHealthUnitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HealthUnit createHealthUnit(@RequestBody HealthUnit healthUnit) {
        return healthUnitService.createHealthUnit(healthUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthUnit> updateHealthUnit(@PathVariable Long id, @RequestBody HealthUnit healthUnitDetails) {
        try {
            return ResponseEntity.ok(healthUnitService.updateHealthUnit(id, healthUnitDetails));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthUnit(@PathVariable Long id) {
        healthUnitService.deleteHealthUnit(id);
        return ResponseEntity.noContent().build();
    }
}
