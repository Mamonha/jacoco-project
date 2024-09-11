package automated.tests.controllers;

import automated.tests.entities.Bed;
import automated.tests.exceptions.ResourceNotFoundException;
import automated.tests.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping
    public List<Bed> getAllBeds() {
        return bedService.getAllBeds();
    }

    @GetMapping("/available")
    public List<Bed> getAvailableBeds() {
        return bedService.getAvailableBeds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBedById(@PathVariable Long id) {
        return bedService.getBedById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bed createBed(@RequestBody Bed bed) {
        return bedService.createBed(bed);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bed> updateBed(@PathVariable Long id, @RequestBody Bed bedDetails) {
        try {
            return ResponseEntity.ok(bedService.updateBed(id, bedDetails));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBed(@PathVariable Long id) {
        bedService.deleteBed(id);
        return ResponseEntity.noContent().build();
    }
}
