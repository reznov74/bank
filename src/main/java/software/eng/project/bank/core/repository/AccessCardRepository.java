package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.AccessCard;
import software.eng.project.bank.core.model.Account.AccessCardAccountFlow;

public interface AccessCardRepository extends JpaRepository<AccessCard, Long>,CrudRepository<AccessCard, Long> {
}
