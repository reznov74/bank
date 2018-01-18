package software.eng.project.bank.core.repository;

import org.springframework.stereotype.Repository;
import software.eng.project.bank.core.model.Account.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountDAO {
    @PersistenceContext
    private EntityManager entityManager;
    public Account find(long id) {
        return entityManager.find(Account.class, id);
    }
}
