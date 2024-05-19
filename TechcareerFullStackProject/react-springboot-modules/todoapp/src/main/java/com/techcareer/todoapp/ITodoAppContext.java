package com.techcareer.todoapp;

import java.util.List;

import com.mrfurkisan.core.contracts.abstracts.BaseDataResponse;
import com.mrfurkisan.core.contracts.abstracts.BaseResponse;
import com.mrfurkisan.core.contracts.requests.SecureDataRequest;
import com.mrfurkisan.core.contracts.requests.SecureRequest;
import com.techcareer.todoapp.application.forms.CreateTodoItemForm;
import com.techcareer.todoapp.application.forms.CreateTodoListForm;
import com.techcareer.todoapp.application.forms.UpdateTodoItemForm;
import com.techcareer.todoapp.entities.TodoList;

public interface ITodoAppContext {

    public BaseResponse CreateTodoListEntity(SecureDataRequest<CreateTodoListForm> req);

    public BaseResponse CreateTodoItem(SecureDataRequest<CreateTodoItemForm> req);

    public BaseResponse DeleteTodoItemById(SecureDataRequest<Integer> req);

    public BaseResponse DeleteTodoListById(SecureDataRequest<Integer> req);

    public BaseResponse UpdateTodoItemByForm(SecureDataRequest<UpdateTodoItemForm> req);

    public BaseDataResponse<List<TodoList>> GetAllTodoListsByToken(SecureRequest req);

}
