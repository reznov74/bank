package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;

@Entity
public class Rank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    RankType type;
//    Branch branch;
}
