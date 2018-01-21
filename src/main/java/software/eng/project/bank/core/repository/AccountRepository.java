package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Role.Admin;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>,CrudRepository<Account, Long> {
    List<Account> findByAccountType_SepordeKotah();
    List<Account> findByAccountType_SepordeBoland();

    @Modifying
    @Transactional
    @Query(value = "")
    void updateCashValue();


}
