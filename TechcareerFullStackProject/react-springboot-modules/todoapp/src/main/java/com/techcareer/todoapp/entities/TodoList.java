package com.techcareer.todoapp.entities;

import com.mrfurkisan.core.domain.AggregateRoot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoList extends AggregateRoot<TodoItem, Integer> {

    private String title;

    public TodoList() {
        
    }

}
