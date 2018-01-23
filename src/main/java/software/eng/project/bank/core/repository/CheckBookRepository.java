package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.CheckBook;
import software.eng.project.bank.core.model.Bank.Branch;

import java.util.List;

public interface CheckBookRepository extends JpaRepository<CheckBook, Long>,CrudRepository<CheckBook, Long> {
    List<CheckBook> findByAccount_Customer_Id(long customerID);
}
