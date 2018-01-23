package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Draft;

import java.util.List;

public interface DraftRepository  extends JpaRepository<Draft, Long>,CrudRepository<Draft, Long> {
    public List<Draft> findBySourceAccount_AccountNumberOrDistAccount_AccountNumberOrderByDraftedDate( String account1 , String account2);
}
