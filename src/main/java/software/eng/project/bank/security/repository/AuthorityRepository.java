package software.eng.project.bank.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.security.model.Authority;
import software.eng.project.bank.security.model.User;

public interface AuthorityRepository extends JpaRepository<Authority, Long>, CrudRepository<Authority,Long> {
    public Authority findById(long id);
}
