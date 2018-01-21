package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.FacilityReturn;
import software.eng.project.bank.core.model.Request.CheckBookRequest;

import java.util.List;

public interface CheckBookRequestRepository extends JpaRepository<CheckBookRequest, Long>,CrudRepository<CheckBookRequest, Long> {
    List<CheckBookRequest> findByStuff_PersonalNumberOrderByRequestDate(long p);
}
