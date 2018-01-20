package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.AccountFlow;
import software.eng.project.bank.core.model.Account.AccountStatus;

public interface AccountFlowRepository extends JpaRepository<AccountFlow, Long>,CrudRepository<AccountFlow, Long> {

}
