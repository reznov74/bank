package software.eng.project.bank.security;

import com.vitamin.thirdparty.bi.bi.security.model.Authority;
import com.vitamin.thirdparty.bi.bi.security.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



public final class JwtUserFactory {

    private JwtUserFactory() {
    }
}
