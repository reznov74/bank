package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.CheckBook;
import software.eng.project.bank.core.model.Account.CreditCrad;

public interface CreditCardRepository extends JpaRepository<CreditCrad, Long>,CrudRepository<CreditCrad, Long> {
}
