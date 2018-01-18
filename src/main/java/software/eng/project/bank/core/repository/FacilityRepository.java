package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.CreditCrad;
import software.eng.project.bank.core.model.Account.Facility;

public interface FacilityRepository  extends JpaRepository<Facility, Long>,CrudRepository<Facility, Long> {
}