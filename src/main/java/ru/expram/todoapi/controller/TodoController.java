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
        return Response.ok(todoService.getAllTasksByTask(task));
    }

    @PostMapping
    public ResponseEntity<TodoDto> createTask(@RequestBody TodoRequest todoRequest) {
        return Response.ok(todoService.createTask(todoRequest));
    }

    @DeleteMapping
    public ResponseEntity<TodoDto> deleteTask(@RequestParam Long id) {
        return Response.ok(todoService.removeTask(id));
    }

    @PutMapping
    public ResponseEntity<TodoDto> changeTaskStatus(@RequestParam Long id) {
        return Response.ok(todoService.changeTaskStatus(id));
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTasks() {
        return Response.ok(todoService.getAllTasks());
    }
}
