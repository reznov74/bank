package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Role.Admin;

public interface AccountRepository extends JpaRepository<Account, Long>,CrudRepository<Account, Long> {
}
