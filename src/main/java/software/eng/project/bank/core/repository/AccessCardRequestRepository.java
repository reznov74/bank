package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.AccessCard;
import software.eng.project.bank.core.model.Request.AccessCardRequest;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import software.eng.project.bank.core.model.Request.RequestStatus;

import java.util.List;

public interface AccessCardRequestRepository extends JpaRepository<AccessCardRequest, Long>,CrudRepository<AccessCardRequest, Long> {
    public List<AccessCardRequest> findByStuff_Id(long p);
    List<AccessCardRequest>  findByStuff_IdAndStatus(long stuffID , RequestStatus requestStatus);
    List<AccessCardRequest> findByAccount_Customer_Id(long customerID);
}
