package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Role.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>,CrudRepository<Admin, Long> {
    Admin findByUser_Id(long id);
}
