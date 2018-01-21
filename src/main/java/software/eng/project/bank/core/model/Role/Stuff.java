package software.eng.project.bank.core.model.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class Stuff extends User{
   @Column
   @NotNull
   long personalNumber;

   @ManyToOne (cascade = {CascadeType.ALL} , fetch = FetchType.EAGER)
   @JoinColumn
   StuffHistory stuffHistory;

   public Stuff(User user) {
      super(user);
   }


   public long getPersonalNumber() {
      return personalNumber;
   }

   public void setPersonalNumber(long personalNumber) {
      this.personalNumber = personalNumber;
   }

   public StuffHistory getStuffHistory() {
      return stuffHistory;
   }

   public void setStuffHistory(StuffHistory stuffHistory) {
      this.stuffHistory = stuffHistory;
   }
}
