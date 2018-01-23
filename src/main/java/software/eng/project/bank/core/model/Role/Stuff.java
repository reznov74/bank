package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.boundry.request.CreateUserRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("3")
public class Stuff extends UserModel {
   @Column(name="personal_number" , unique = true)
   long personalNumber;

   @ManyToOne (cascade = {CascadeType.ALL} , fetch = FetchType.EAGER)
   @JoinColumn
   StuffHistory stuffHistory;


   public Stuff(CreateUserRequest user) {
      super(user);
   }
   public Stuff(){

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
