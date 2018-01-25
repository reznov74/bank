package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Account.Facility;

import java.util.List;

public interface FacilityRepository  extends JpaRepository<Facility, Long>,CrudRepository<Facility, Long> {
    List<Facility> findByAccount_Customer_Id(long customerID);
}
