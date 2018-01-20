package software.eng.project.bank.core.model.Response;

import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "request_response")
public class RequestResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "isAccept")
    @NotNull
    boolean isAccept;
    @Column(name = "answerTime")
    @NotNull
    Timestamp answerTime;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "stuff")
    Stuff stuff;
    @Column(name = "forWhy")
    @NotNull
    String forWhy;

    public RequestResponse(boolean isAccept, Timestamp answerTime, Stuff stuff, String forWhy) {
        this.isAccept = isAccept;
        this.answerTime = answerTime;
        this.stuff = stuff;
        this.forWhy = forWhy;
    }

    public RequestResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public String getForWhy() {
        return forWhy;
    }

    public void setForWhy(String forWhy) {
        this.forWhy = forWhy;
    }
}
