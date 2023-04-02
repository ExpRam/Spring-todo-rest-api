package ru.expram.todoapi.dto.mapper;

import ru.expram.todoapi.dto.model.TodoDto;
import ru.expram.todoapi.model.Todo;

public class TodoMapper {
     public static TodoDto toTodoDto(Todo todo) {
         return new TodoDto()
                 .setId(todo.getId())
                 .setTask(todo.getTask())
                 .setCompleted(todo.isCompleted());
     }
}
