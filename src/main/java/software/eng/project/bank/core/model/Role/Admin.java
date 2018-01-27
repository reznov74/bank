package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.boundry.request.CreateUserRequest;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorValue("2")
public class Admin extends UserModel {

    @Override
    public String getTypeRole(){
        return "ADMIN";
    }
    public Admin(CreateUserRequest user) {
        super(user);
    }
    public Admin(){

    }
}
