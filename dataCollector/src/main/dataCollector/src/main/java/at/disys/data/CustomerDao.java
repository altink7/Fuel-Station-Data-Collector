package at.disys.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import at.disys.model.Customer;

/**
 * This class is responsible for the database access of the customer entity.
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
}
