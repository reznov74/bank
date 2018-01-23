package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Role.Admin;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.Stuff;

public interface CustomerRepository extends JpaRepository<Customer, Long>,CrudRepository<Customer, Long> {
    Customer findByUser_Id(long id);
    Customer findByNationalCode(String nationalCode);
}
