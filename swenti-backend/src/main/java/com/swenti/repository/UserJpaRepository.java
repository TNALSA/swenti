package com.swenti.repository;

import com.swenti.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends JpaRepository<User,String> {
    @Query("SELECT COUNT(*) FROM User u WHERE u.id = :id AND u.password = :password")
    String checkUserPassword(@Param("id") String id, @Param("password") String password);
}
