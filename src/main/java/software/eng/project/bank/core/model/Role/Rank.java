package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    RankType type;
    @OneToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "branch")
    Branch branch;

    public Rank(RankType type, Branch branch) {
        this.type = type;
        this.branch = branch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RankType getType() {
        return type;
    }

    public void setType(RankType type) {
        this.type = type;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
