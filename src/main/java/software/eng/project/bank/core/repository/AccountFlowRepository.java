package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.boundry.request.AccountFlowType;
import software.eng.project.bank.core.model.Account.AccountFlow;

import java.util.List;

public interface AccountFlowRepository extends JpaRepository<AccountFlow, Long>,CrudRepository<AccountFlow, Long> {
    List<AccountFlow> findByAccount_AccountNumberAndTypeOrderByDate( String accountID , AccountFlowType accountFlowType);
    List<AccountFlow> findByAccount_AccountNumberOrderByDate( String accountID);
}
