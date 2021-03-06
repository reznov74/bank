package software.eng.project.bank.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.security.model.User;


/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> , CrudRepository<User,Long> {
    User findByUsername(String username);
}
