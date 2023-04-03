package at.disys.repo;

import at.disys.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepo extends JpaRepository<Charge, Long> {

}
