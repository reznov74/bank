package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Check;
import software.eng.project.bank.core.model.Account.CheckBook;
import software.eng.project.bank.core.model.Account.CheckID;

public interface CheckRepository extends JpaRepository<Check, CheckID>,CrudRepository<Check, CheckID> {
}
