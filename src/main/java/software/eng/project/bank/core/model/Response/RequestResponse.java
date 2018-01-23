package software.eng.project.bank.core.model.Response;

import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "request_response")
public class RequestResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "is_accept")
    @NotNull
    boolean isAccept;

    @Column(name = "answer_time")
    Date answerTime;

    @Column(name = "for_why")
    String forWhy;

    @Column(name = "day_required_for_ready")
    int dayRequiredForReady;

    public RequestResponse(boolean isAccept, Date answerTime, String forWhy) {
        this.isAccept = isAccept;
        this.answerTime = answerTime;
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

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getForWhy() {
        return forWhy;
    }

    public void setForWhy(String forWhy) {
        this.forWhy = forWhy;
    }

    public int getDayRequiredForReady() {
        return dayRequiredForReady;
    }

    public void setDayRequiredForReady(int dayRequiredForReady) {
        this.dayRequiredForReady = dayRequiredForReady;
    }
}
