package ru.expram.todoapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoRequest {
    private String task;
    private boolean completed;
}
