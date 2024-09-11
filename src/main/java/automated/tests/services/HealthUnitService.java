package automated.tests.services;

import automated.tests.entities.HealthUnit;
import automated.tests.exceptions.ResourceNotFoundException;
import automated.tests.repositories.HealthUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthUnitService {

    @Autowired
    private HealthUnitRepository healthUnitRepository;

    public List<HealthUnit> getAllHealthUnits() {
        return healthUnitRepository.findAll();
    }

    public Optional<HealthUnit> getHealthUnitById(Long id) {
        return healthUnitRepository.findById(id);
    }

    public HealthUnit createHealthUnit(HealthUnit healthUnit) {
        return healthUnitRepository.save(healthUnit);
    }

    public HealthUnit updateHealthUnit(Long id, HealthUnit healthUnitDetails) {
        return healthUnitRepository.findById(id)
                .map(healthUnit -> {
                    healthUnit.setName(healthUnitDetails.getName());
                    healthUnit.setNumberOfEnfermariaBeds(healthUnitDetails.getNumberOfEnfermariaBeds());
                    healthUnit.setNumberOfUTIBeds(healthUnitDetails.getNumberOfUTIBeds());
                    return healthUnitRepository.save(healthUnit);
                }).orElseThrow(() -> new ResourceNotFoundException("Health Unit not found with id " + id));
    }

    public void deleteHealthUnit(Long id) {
        healthUnitRepository.findById(id)
                .ifPresent(healthUnitRepository::delete);
    }
}
