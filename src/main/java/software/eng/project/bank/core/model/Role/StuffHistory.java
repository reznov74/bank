package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class StuffHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
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

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
