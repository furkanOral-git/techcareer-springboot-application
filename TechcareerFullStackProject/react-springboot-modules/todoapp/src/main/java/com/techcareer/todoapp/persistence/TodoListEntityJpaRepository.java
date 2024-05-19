package com.techcareer.todoapp.persistence;

import com.mrfurkisan.core.infrastructure.persistence.BaseJpaRepository;
import com.techcareer.todoapp.entities.TodoListEntity;
import com.techcareer.todoapp.repositories.ITodoListEntityRepository;

import jakarta.persistence.EntityManager;

public class TodoListEntityJpaRepository extends BaseJpaRepository<TodoListEntity> implements ITodoListEntityRepository  {
    public TodoListEntityJpaRepository(EntityManager manager) {
        super(manager, TodoListEntity.class);
    }
}
