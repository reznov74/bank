package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.AccountType;
import software.eng.project.bank.core.model.Role.Admin;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>,CrudRepository<Account, Long> {
    List<Account> findByAccountTypeEquals(AccountType accountType);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Account SET cash = :newCash where id= :accountID")
    void updateCashValue(@Param("newCash") double newCash , @Param("accountID") long accountID );


}
