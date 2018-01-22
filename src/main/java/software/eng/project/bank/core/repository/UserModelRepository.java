package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Role.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long>,CrudRepository<UserModel, Long> {
}
