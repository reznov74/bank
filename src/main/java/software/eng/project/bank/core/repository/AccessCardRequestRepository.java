package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.AccessCard;
import software.eng.project.bank.core.model.Request.AccessCardRequest;

public interface AccessCardRequestRepository extends JpaRepository<AccessCardRequest, Long>,CrudRepository<AccessCardRequest, Long> {
}
