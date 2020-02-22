package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(int id);

    User getByUsernameAndPassword(String username, String password);

    Boolean existsByUsername(String username);

    @Query(nativeQuery = true,value = "select *from user where username=:parUs")
    User getByUsername(@Param("parUs") String username);

}
