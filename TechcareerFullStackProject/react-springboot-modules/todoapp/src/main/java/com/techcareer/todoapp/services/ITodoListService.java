package com.techcareer.todoapp.services;

import java.util.List;

import com.techcareer.todoapp.entities.TodoListEntity;

public interface ITodoListService {

    public void Add(TodoListEntity item);

    public void UpdateTodoListEntityTitleById(TodoListEntity item, int id);

    public List<TodoListEntity> GetAllTodoListsByUserId(int listId);

    public TodoListEntity GetTodoListById(int listId);

    public void DeleteTodoListById(int listId);

    public void DeleteTodoListsByUserId(int userId);
}
