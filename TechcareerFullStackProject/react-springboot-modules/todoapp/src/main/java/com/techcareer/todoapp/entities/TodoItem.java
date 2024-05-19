package com.techcareer.todoapp.entities;

import com.mrfurkisan.core.domain.interfaces.IAggregateRootItem;
import com.mrfurkisan.core.domain.interfaces.IEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "todo_items")
public class TodoItem implements IAggregateRootItem, IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer list_id;
    private String content;
    private Boolean status;

}
