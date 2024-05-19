package com.techcareer.todoapp.persistence;

import com.mrfurkisan.core.infrastructure.persistence.BaseJpaRepository;
import com.techcareer.todoapp.entities.TodoItem;
import com.techcareer.todoapp.repositories.ITodoItemRepository;

import jakarta.persistence.EntityManager;

public class TodoItemJpaRepository extends BaseJpaRepository<TodoItem> implements ITodoItemRepository {

    public TodoItemJpaRepository(EntityManager manager) {
        super(manager, TodoItem.class);

    }
}
