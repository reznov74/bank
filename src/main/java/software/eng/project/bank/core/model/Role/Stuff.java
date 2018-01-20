package software.eng.project.bank.core.model.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class Stuff extends User{
   @Column(name = "code")
   @NotNull
   long personalNumber;
   
}
