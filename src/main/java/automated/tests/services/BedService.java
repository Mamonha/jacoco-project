package automated.tests.services;

import automated.tests.entities.Bed;
import automated.tests.exceptions.ResourceNotFoundException;
import automated.tests.repositories.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    public Optional<Bed> getBedById(Long id) {
        return bedRepository.findById(id);
    }

    public List<Bed> getAvailableBeds() {
        return bedRepository.findByIsOccupiedFalse();
    }

    public Bed createBed(Bed bed) {
        bed.setOccupied(false);
        return bedRepository.save(bed);
    }

    public Bed updateBed(Long id, Bed bedDetails) {
        return bedRepository.findById(id)
                .map(bed -> {
                    bed.setType(bedDetails.getType());
                    bed.setOccupied(bedDetails.isOccupied());
                    return bedRepository.save(bed);
                }).orElseThrow(() -> new ResourceNotFoundException("Bed not found with id " + id));
    }

    public void deleteBed(Long id) {
        bedRepository.findById(id)
                .ifPresent(bedRepository::delete);
    }
}
