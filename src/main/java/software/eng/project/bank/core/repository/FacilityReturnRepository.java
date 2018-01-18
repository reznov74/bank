package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.FacilityReturn;
import software.eng.project.bank.core.model.Account.FacilityReturnRegular;

public interface FacilityReturnRepository extends JpaRepository<FacilityReturn, Long>,CrudRepository<FacilityReturn, Long> {
}
