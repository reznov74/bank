package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.CheckBook;
import software.eng.project.bank.core.model.Bank.Branch;

public interface CheckBookRepository extends JpaRepository<CheckBook, Long>,CrudRepository<CheckBook, Long> {

}
