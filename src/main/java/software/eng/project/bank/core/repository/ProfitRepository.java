package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Profit;

import java.util.List;

public interface ProfitRepository extends JpaRepository<Profit, Long>,CrudRepository<Profit, Long> {
    List<Profit> findByAccount_Id(long accountID);
}
