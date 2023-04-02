package ru.expram.todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.expram.todoapi.dto.mapper.TodoMapper;
import ru.expram.todoapi.dto.model.TodoDto;
import ru.expram.todoapi.dto.request.TodoRequest;
import ru.expram.todoapi.exceptions.TaskNotFoundException;
import ru.expram.todoapi.model.Todo;
import ru.expram.todoapi.repository.TodoRepository;
import ru.expram.todoapi.service.TodoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Override
    public TodoDto createTask(TodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setTask(todoRequest.getTask());
        todo.setCompleted(todoRequest.isCompleted());
        todoRepository.save(todo);
        return TodoMapper.toTodoDto(todo);
    }

    @Override
    public TodoDto removeTask(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()) {
            todoRepository.delete(todo.get());
            return TodoMapper.toTodoDto(todo.get());
        } else throw new TaskNotFoundException("Cannot find task with id " + id);
    }

    @Override
    public List<TodoDto> getAllTasks() {
        return todoRepository.findAll().stream().map(TodoMapper::toTodoDto).collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> getAllTasksByTask(String task) {
        List<TodoDto> todoDtos = todoRepository.findAllByTaskStartsWith(task).
                stream().map(TodoMapper::toTodoDto).collect(Collectors.toList());
         if(todoDtos.isEmpty()) throw new TaskNotFoundException("Cannot find task that starts with name " + task);
        return todoDtos;
    }

    @Override
    public TodoDto changeTaskStatus(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()) {
            todo.get().setCompleted(!todo.get().isCompleted());
            todoRepository.save(todo.get());
            return TodoMapper.toTodoDto(todo.get());
        }  else throw new TaskNotFoundException("Cannot find task with id " + id);
    }
}
