package com.techcareer.todoapp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

import com.mrfurkisan.core.application.auth.ITokenService;
import com.mrfurkisan.core.contracts.abstracts.*;
import com.mrfurkisan.core.contracts.requests.*;
import com.mrfurkisan.core.contracts.responses.*;
import com.techcareer.todoapp.application.forms.*;
import com.techcareer.todoapp.entities.*;
import com.techcareer.todoapp.services.ITodoItemService;
import com.techcareer.todoapp.services.ITodoListService;
import com.techcareer.todoapp.services.TodoItemService;
import com.techcareer.todoapp.services.TodoListService;

public class TodoAppContext implements ITodoAppContext {

    @Autowired
    private TodoListService __listService;
    @Autowired
    private TodoItemService __itemService;
    @Autowired
    private ITokenService __tokenService;

    public TodoAppContext(ITodoItemService itemService, ITodoListService listService, ITokenService tokenService) {
        this.__itemService = (TodoItemService) itemService;
        this.__listService = (TodoListService) listService;
        this.__tokenService = tokenService;
    }

    @Override
    public BaseResponse CreateTodoListEntity(SecureDataRequest<CreateTodoListForm> req) {

        int userId = this.__tokenService.ValidateTokenAndReturnUserId(req.GetToken().GetId());
        if (userId == -1) {
            return new ErrorDataResponse<TodoList>("Önce giriş yapmalisiniz");
        }
        var form = req.GetData();
        var list = new TodoListEntity();
        // Hata almamak için id'yi manual atıyorum!.
        // Entity manager'ı direkt olarak criteria api kullanmadan persist() şeklinde
        // kullanılırsa verilen nesnenin
        // bütün propertyleri dolu olmalı!
        list.setId(0);
        list.setUser_id(userId);
        list.setTitle(form.getTitle());

        this.__listService.Add(list);
        return new SuccessResponse("Todo list oluşturuldu.");

    }

    @Override
    public BaseResponse CreateTodoItem(
            SecureDataRequest<CreateTodoItemForm> req) {

        int userId = this.__tokenService.ValidateTokenAndReturnUserId(req.GetToken().GetId());
        if (userId == -1) {
            return new ErrorDataResponse<TodoItem>("Önce giriş yapmalisiniz");
        }
        var form = req.GetData();

        var entityList = this.__listService.GetTodoListById(form.getList_id());
        if (entityList == null) {

            return new ErrorDataResponse<TodoItem>("Böyle bir liste yok");
        }

        var item = new TodoItem();
        // Aynı durum burası için de geçerli :)
        item.setId(0);
        item.setContent(form.getContent());
        item.setList_id(form.getList_id());

        item.setStatus(false);
        this.__itemService.DeleteTodoItemById(0);
        this.__itemService.Add(item);
        return new SuccessResponse("Todo item oluşturuldu.");

    }

    @Override
    public BaseResponse DeleteTodoListById(SecureDataRequest<Integer> req) {

        int userId = this.__tokenService.ValidateTokenAndReturnUserId(req.GetToken().GetId());
        if (userId == -1) {
            return new ErrorResponse("Önce giriş yapmalisiniz");
        }
        var listId = req.GetData();
        this.__listService.DeleteTodoListById(listId);
        this.__itemService.DeleteTodoItemsByListId(listId);
        return new SuccessResponse("Başariyla silindi");
    }

    @Override
    public BaseDataResponse<List<TodoList>> GetAllTodoListsByToken(SecureRequest req) {

        int userId = this.__tokenService.ValidateTokenAndReturnUserId(req.GetToken().GetId());
        if (userId == -1) {
            return new ErrorDataResponse<List<TodoList>>("Önce giriş yapmalisiniz");
        }
        var entityTodoLists = this.__listService.GetAllTodoListsByUserId(userId);

        List<TodoList> values = new ArrayList<TodoList>();

        for (TodoListEntity entity : entityTodoLists) {

            TodoList list = new TodoList();
            list.setId(entity.getId());
            var items = this.__itemService.GetAllTodoItemsByListId(entity.getId());
            list.setAggregate(items);
            values.add(list);
        }
        return new SuccessDataResponse<List<TodoList>>("Hoşgeldiniz.", values);
    }

    @Override
    public BaseResponse DeleteTodoItemById(SecureDataRequest<Integer> req) {

        int userId = this.__tokenService.ValidateTokenAndReturnUserId(req.GetToken().GetId());
        if (userId == -1) {
            return new ErrorResponse("Önce giriş yapmalisiniz");
        }
        var todoId = req.GetData();
        this.__itemService.DeleteTodoItemById(todoId);
        return new SuccessResponse("Başariyla silindi");
    }

    @Override
    public BaseResponse UpdateTodoItemByForm(SecureDataRequest<UpdateTodoItemForm> req) {

        int userId = this.__tokenService.ValidateTokenAndReturnUserId(req.GetToken().GetId());
        if (userId == -1) {
            return new ErrorResponse("Önce giriş yapmalisiniz");
        }
        TodoItem todo = this.__itemService.GetTodoItemById(req.GetData().getId());
        if (todo == null) {
            return new ErrorResponse("Böyle bir todo item yok!");
        }
        this.__itemService.UpdateTodoItem(req.GetData());
        return new SuccessResponse("Başarili");
    }

}
