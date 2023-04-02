package ru.expram.todoapi.dto.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TodoDto {
    private Long id;
    private String task;
    private boolean completed;
}
