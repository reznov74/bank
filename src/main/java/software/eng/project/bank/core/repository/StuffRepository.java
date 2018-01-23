package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.FacilityReturn;
import software.eng.project.bank.core.model.Role.Stuff;

import java.util.List;

public interface StuffRepository extends JpaRepository<Stuff, Long>,CrudRepository<Stuff, Long> {
    Stuff findByUser_Id(long id);
    List<Stuff> findByBranch_Id(long branchID);
}
