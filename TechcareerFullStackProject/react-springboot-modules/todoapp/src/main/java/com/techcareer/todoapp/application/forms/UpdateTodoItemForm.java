package com.techcareer.todoapp.application.forms;

import lombok.Getter;

@Getter
public class UpdateTodoItemForm {
    private int id;
    private String content;
    private Boolean status;
}
