package software.eng.project.bank.core.model.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("3")
public class Stuff extends UserModel {
   @Column
   @NotNull
   long personalNumber;

   @ManyToOne (cascade = {CascadeType.ALL} , fetch = FetchType.EAGER)
   @JoinColumn
   StuffHistory stuffHistory;


   public Stuff(UserModel user) {
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
