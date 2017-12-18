package com.vitamin.thirdparty.bi.bi.security.repository;

import com.vitamin.thirdparty.bi.bi.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
