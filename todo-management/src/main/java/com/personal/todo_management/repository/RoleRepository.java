package com.personal.todo_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.todo_management.entity.Role;
import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
