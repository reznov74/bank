package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.FacilityReturn;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import software.eng.project.bank.core.model.Request.RequestStatus;

import java.util.List;

public interface CheckBookRequestRepository extends JpaRepository<CheckBookRequest, Long>,CrudRepository<CheckBookRequest, Long> {
    List<CheckBookRequest> findByStuff_Id(long p);
    List<CheckBookRequest> findByStuff_IdAndStatus(long stuffID , RequestStatus requestStatus);
    List<CheckBookRequest> findByCustomer_Id(long p );
}
