package com.techcareer.todoapp.services;

import java.util.List;

import com.mrfurkisan.core.domain.functional.IJpaFunctionalInterface;

import com.techcareer.todoapp.entities.TodoListEntity;
import com.techcareer.todoapp.persistence.TodoListEntityJpaRepository;
import com.techcareer.todoapp.repositories.ITodoListEntityRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TodoListService implements ITodoListService {

    private TodoListEntityJpaRepository __repo;

    public TodoListService(ITodoListEntityRepository repo) {
        super();
        this.__repo = (TodoListEntityJpaRepository) repo;
    }

    @Override
    public void Add(TodoListEntity item) {
        this.__repo.Add(item);
    }

    
    @Override
    public void UpdateTodoListEntityTitleById(TodoListEntity item, int id) {

        IJpaFunctionalInterface<TodoListEntity, CriteriaUpdate<TodoListEntity>> filter = (CriteriaBuilder builder) -> {
            CriteriaUpdate<TodoListEntity> update = builder.createCriteriaUpdate(TodoListEntity.class);
            Root<TodoListEntity> table = update.from(TodoListEntity.class);

            update.set("title", item.getTitle());

            Predicate pre = builder.equal(table.get("id"), item.getId());
            update.where(pre);
            return update;
        };
        this.__repo.UpdateBy(filter);
    }

    @Override
    public List<TodoListEntity> GetAllTodoListsByUserId(int userId) {

        IJpaFunctionalInterface<TodoListEntity, CriteriaQuery<TodoListEntity>> filter = (CriteriaBuilder builder) -> {
            CriteriaQuery<TodoListEntity> query = builder.createQuery(TodoListEntity.class);
            Root<TodoListEntity> table = query.from(TodoListEntity.class);

            Predicate pre = builder.equal(table.get("user_id"), userId);
            query.where(pre);
            return query;
        };
        return this.__repo.GetAllBy(filter);
    }

    @Override
    public TodoListEntity GetTodoListById(int listId) {

        IJpaFunctionalInterface<TodoListEntity, CriteriaQuery<TodoListEntity>> filter = (CriteriaBuilder builder) -> {
            CriteriaQuery<TodoListEntity> query = builder.createQuery(TodoListEntity.class);
            Root<TodoListEntity> table = query.from(TodoListEntity.class);

            Predicate pre = builder.equal(table.get("id"), listId);
            query.where(pre);
            return query;
        };
        return this.__repo.GetBy(filter);
    }

    @Override
    public void DeleteTodoListById(int listId) {

        IJpaFunctionalInterface<TodoListEntity, CriteriaDelete<TodoListEntity>> filter = (CriteriaBuilder builder) -> {

            CriteriaDelete<TodoListEntity> delete = builder.createCriteriaDelete(TodoListEntity.class);
            Root<TodoListEntity> table = delete.from(TodoListEntity.class);

            Predicate pre = builder.equal(table.get("id"), listId);
            delete.where(pre);
            return delete;
        };
        this.__repo.DeleteBy(filter);
    }

    @Override
    public void DeleteTodoListsByUserId(int userId) {

        IJpaFunctionalInterface<TodoListEntity, CriteriaDelete<TodoListEntity>> filter = (CriteriaBuilder builder) -> {

            CriteriaDelete<TodoListEntity> delete = builder.createCriteriaDelete(TodoListEntity.class);
            Root<TodoListEntity> table = delete.from(TodoListEntity.class);

            Predicate pre = builder.equal(table.get("user_id"), userId);
            delete.where(pre);
            return delete;
        };
        this.__repo.DeleteBy(filter);
    }

}
