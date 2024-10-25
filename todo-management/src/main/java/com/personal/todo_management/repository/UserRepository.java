package com.personal.todo_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.personal.todo_management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName like ?1 OR u.email like ?1")
    public Optional<User> findbyUsernameOrEmail(String usernameOrEmail);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String username);
}
