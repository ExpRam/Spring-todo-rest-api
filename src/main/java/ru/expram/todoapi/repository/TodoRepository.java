package ru.expram.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.expram.todoapi.model.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByTaskStartsWith(String task);
}
