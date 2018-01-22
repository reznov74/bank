package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.FacilityReturn;
import software.eng.project.bank.core.model.Role.Stuff;

public interface StuffRepository extends JpaRepository<Stuff, Long>,CrudRepository<Stuff, Long> {
    Stuff findByUser_Id(long id);
}
