package com.swenti.repository;

import com.swenti.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends JpaRepository<User,String> {
    @Query("SELECT COUNT(*) FROM User u WHERE u.id = :id AND u.password = :password")
    String checkUserPassword(@Param("id") String id, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.id = :userid")
    User getUesrInfo(@Param("userid") String userid);

    @Modifying
    @Query("UPDATE User u SET u.phone = :contact WHERE u.id = :userid")
    void updateUserInfo( @Param("contact") String contact, @Param("userid") String userid);
}
