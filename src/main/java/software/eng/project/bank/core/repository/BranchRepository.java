package software.eng.project.bank.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import software.eng.project.bank.core.model.Bank.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long>,CrudRepository<Branch, Long> {
    public Branch findByBarnchCode(int branchCode);
}
