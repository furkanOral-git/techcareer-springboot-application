package com.techcareer.todoapp.services;

import java.util.List;

import com.mrfurkisan.core.domain.functional.IJpaFunctionalInterface;
import com.techcareer.todoapp.application.forms.UpdateTodoItemForm;
import com.techcareer.todoapp.entities.TodoItem;
import com.techcareer.todoapp.persistence.TodoItemJpaRepository;
import com.techcareer.todoapp.repositories.ITodoItemRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TodoItemService implements ITodoItemService {

    private TodoItemJpaRepository __repo;

    public TodoItemService(ITodoItemRepository repo) {
        super();
        this.__repo = (TodoItemJpaRepository) repo;
    }

    @Override
    public void Add(TodoItem item) {
        this.__repo.Add(item);
    }

    @Override
    public void UpdateTodoItemById(TodoItem item, int id) {

        IJpaFunctionalInterface<TodoItem, CriteriaUpdate<TodoItem>> filter = (CriteriaBuilder builder) -> {
            CriteriaUpdate<TodoItem> update = builder.createCriteriaUpdate(TodoItem.class);
            Root<TodoItem> table = update.from(TodoItem.class);

            update.set("content", item.getContent());
            update.set("status", item.getStatus());

            Predicate pre = builder.equal(table.get("id"), item.getId());
            update.where(pre);
            return update;
        };
        this.__repo.UpdateBy(filter);
    }

    @Override
    public List<TodoItem> GetAllTodoItemsByListId(int listId) {

        IJpaFunctionalInterface<TodoItem, CriteriaQuery<TodoItem>> filter = (CriteriaBuilder builder) -> {
            CriteriaQuery<TodoItem> query = builder.createQuery(TodoItem.class);
            Root<TodoItem> table = query.from(TodoItem.class);

            Predicate pre = builder.equal(table.get("list_id"), listId);
            query.where(pre);
            return query;
        };
        return this.__repo.GetAllBy(filter);
    }

    @Override
    public void DeleteTodoItemsByListId(int listId) {

        IJpaFunctionalInterface<TodoItem, CriteriaDelete<TodoItem>> filter = (CriteriaBuilder builder) -> {

            CriteriaDelete<TodoItem> update = builder.createCriteriaDelete(TodoItem.class);
            Root<TodoItem> table = update.from(TodoItem.class);

            Predicate pre = builder.equal(table.get("list_id"), listId);
            update.where(pre);
            return update;
        };
        this.__repo.DeleteBy(filter);
    }

    @Override
    public void DeleteTodoItemById(int id) {

        IJpaFunctionalInterface<TodoItem, CriteriaDelete<TodoItem>> filter = (CriteriaBuilder builder) -> {

            CriteriaDelete<TodoItem> update = builder.createCriteriaDelete(TodoItem.class);
            Root<TodoItem> table = update.from(TodoItem.class);

            Predicate pre = builder.equal(table.get("id"), id);
            update.where(pre);
            return update;
        };
        this.__repo.DeleteBy(filter);
    }

    @Override
    public TodoItem GetTodoItemById(int id) {

        IJpaFunctionalInterface<TodoItem, CriteriaQuery<TodoItem>> filter = (CriteriaBuilder builder) -> {
            CriteriaQuery<TodoItem> query = builder.createQuery(TodoItem.class);
            Root<TodoItem> table = query.from(TodoItem.class);

            Predicate pre = builder.equal(table.get("id"), id);
            query.where(pre);
            return query;
        };
        return this.__repo.GetBy(filter);
    }

    @Override
    public void UpdateTodoItem(UpdateTodoItemForm form) {

        IJpaFunctionalInterface<TodoItem, CriteriaUpdate<TodoItem>> filter = (CriteriaBuilder builder) -> {
            CriteriaUpdate<TodoItem> update = builder.createCriteriaUpdate(TodoItem.class);
            Root<TodoItem> table = update.from(TodoItem.class);

            update.set("status", form.getStatus());
            update.set("content", form.getContent());

            Predicate pre = builder.equal(table.get("id"), form.getId());
            update.where(pre);
            return update;
        };
        this.__repo.UpdateBy(filter);
    }

}
