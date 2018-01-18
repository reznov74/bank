package software.eng.project.bank.core.model.Request;

import javax.persistence.*;

enum CheckBookType{}
@Entity
public class CheckBookRequest extends Request{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    int numberOfCheck;
    @Enumerated(EnumType.STRING)
    @Column
    CheckBookType type;

}
