package at.disys.data;

import at.disys.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class is responsible for the database access of the charge entity.
 */
public interface ChargeDao extends JpaRepository<Charge, Long> {

    /**
     * find all charges by customer id
     */
    Iterable<Charge> findAllByCustomerId(Long customerId);
}
