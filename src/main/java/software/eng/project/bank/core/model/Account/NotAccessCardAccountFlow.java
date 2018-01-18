package software.eng.project.bank.core.model.Account;

import javax.persistence.*;

@Entity
public class NotAccessCardAccountFlow extends AccountFlow {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
