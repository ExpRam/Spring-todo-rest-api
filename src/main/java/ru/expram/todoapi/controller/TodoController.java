package ru.expram.todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.expram.todoapi.dto.model.TodoDto;
import ru.expram.todoapi.dto.request.TodoRequest;
import ru.expram.todoapi.dto.response.Response;
import ru.expram.todoapi.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/find")
    public ResponseEntity<List<TodoDto>> getAllTasksByTask(@RequestParam String task) {
        return new Response<List<TodoDto>>().setData(todoService.getAllTasksByTask(task)).build();
    }

    @PostMapping
    public ResponseEntity<TodoDto> createTask(@RequestBody TodoRequest todoRequest) {
        return new Response<TodoDto>().setData(todoService.createTask(todoRequest)).build();
    }

    @DeleteMapping
    public ResponseEntity<TodoDto> deleteTask(@RequestParam Long id) {
        return new Response<TodoDto>().setData(todoService.removeTask(id)).build();
    }

    @PutMapping
    public ResponseEntity<TodoDto> changeTaskStatus(@RequestParam Long id) {
        return new Response<TodoDto>().setData(todoService.changeTaskStatus(id)).build();
    }

    @GetMapping
    public ResponseEntity getAllTasks() {
        return new Response<List<TodoDto>>().setData(todoService.getAllTasks()).build();
    }
}
