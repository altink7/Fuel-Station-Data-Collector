package at.disys.data;

import at.disys.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class is responsible for the database access of the station entity.
 */
public interface StationDao extends JpaRepository<Station, Long> {
}
