package ru.expram.todoapi.service;

import ru.expram.todoapi.dto.model.TodoDto;
import ru.expram.todoapi.dto.request.TodoRequest;

import java.util.List;

public interface TodoService {
    TodoDto createTask(TodoRequest todoRequest);

    TodoDto removeTask(Long id);

    List<TodoDto> getAllTasks();

    List<TodoDto> getAllTasksByTask(String task);

    TodoDto changeTaskStatus(Long id);
}
