package software.eng.project.bank.core.model.Role;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorValue("2")
public class Admin extends UserModel {

    public Admin(UserModel user) {
        super(user);
    }
    public Admin(){

    }
}
