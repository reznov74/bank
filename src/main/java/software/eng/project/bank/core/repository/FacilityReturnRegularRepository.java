package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Facility;
import software.eng.project.bank.core.model.Account.FacilityReturnRegular;

public interface FacilityReturnRegularRepository  extends JpaRepository<FacilityReturnRegular, Long>,CrudRepository<FacilityReturnRegular, Long> {
}
