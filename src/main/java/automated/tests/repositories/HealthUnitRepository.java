package automated.tests.repositories;

import automated.tests.entities.HealthUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthUnitRepository extends JpaRepository<HealthUnit, Long> {}

