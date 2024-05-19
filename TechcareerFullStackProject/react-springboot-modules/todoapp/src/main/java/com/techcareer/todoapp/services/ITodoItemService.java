package com.techcareer.todoapp.services;

import java.util.List;

import com.techcareer.todoapp.application.forms.UpdateTodoItemForm;
import com.techcareer.todoapp.entities.TodoItem;

public interface ITodoItemService {

    public void Add(TodoItem item);

    public void UpdateTodoItemById(TodoItem item, int id);

    public void UpdateTodoItem(UpdateTodoItemForm status);

    public List<TodoItem> GetAllTodoItemsByListId(int listId);

    public TodoItem GetTodoItemById(int id);

    public void DeleteTodoItemsByListId(int listId);

    public void DeleteTodoItemById(int id);
}
