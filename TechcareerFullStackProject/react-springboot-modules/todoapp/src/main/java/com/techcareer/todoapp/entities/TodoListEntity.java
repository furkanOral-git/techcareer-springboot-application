package com.techcareer.todoapp.entities;

import com.mrfurkisan.core.domain.interfaces.IEntityAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "todo_lists")
public class TodoListEntity implements IEntityAggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;
    private String title;
}
