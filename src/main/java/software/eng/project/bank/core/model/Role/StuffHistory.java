package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class StuffHistory {
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "stuff")
    Stuff stuff;
    @Column(name = "start")
    @NotNull
    Date start;
    @Column(name = "end")
    Date end;
    @OneToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "rank")
    Rank rank;
}
