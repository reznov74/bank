package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Facility;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import software.eng.project.bank.core.model.Request.FacilityRequest;
import software.eng.project.bank.core.model.Request.RequestStatus;

import java.util.List;

public interface FacilityRequestRepository  extends JpaRepository<FacilityRequest, Long>,CrudRepository<FacilityRequest, Long> {
    List<FacilityRequest> findByStuff_Id(long p);
    List<FacilityRequest> findByStuff_IdAndStatus(long stuffID , RequestStatus requestStatus);
    List<FacilityRequest> findByAccount_Customer_Id(long customerID);
}
