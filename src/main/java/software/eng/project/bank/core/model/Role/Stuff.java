package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.boundry.request.CreateUserRequest;
import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("3")
public class Stuff extends UserModel {
   @Column(name="personal_number" , unique = true)
   long personalNumber;

   @Enumerated(EnumType.STRING)
   @Column(name = "type")
   @NotNull
   RankType type;

   @OneToOne(fetch=FetchType.EAGER )
   @JoinColumn(name = "branch")
   @NotNull
   Branch branch;

   public Stuff(CreateUserRequest user) {
      super(user);
   }
   public Stuff(){

   }

   public RankType getType() {
      return type;
   }

   public void setType(RankType type) {
      this.type = type;
   }

   public Branch getBranch() {
      return branch;
   }

   public void setBranch(Branch branch) {
      this.branch = branch;
   }

   public long getPersonalNumber() {
      return personalNumber;
   }

   public void setPersonalNumber(long personalNumber) {
      this.personalNumber = personalNumber;
   }

}
