package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.FacilityReturn;
import software.eng.project.bank.core.model.Account.FacilityReturnRegular;

import java.util.List;

public interface FacilityReturnRepository extends JpaRepository<FacilityReturn, Long>,CrudRepository<FacilityReturn, Long> {
    public List<FacilityReturn> findByFacility_Account_Customer_Id(long c);
}
