package com.personal.todo_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.todo_management.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
