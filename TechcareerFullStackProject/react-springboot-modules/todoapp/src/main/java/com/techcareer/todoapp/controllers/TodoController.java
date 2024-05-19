package com.techcareer.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mrfurkisan.core.application.forms.DataForm;
import com.mrfurkisan.core.contracts.abstracts.*;
import com.mrfurkisan.core.contracts.requests.*;
import com.mrfurkisan.core.security.authentication.SecurityToken;

import com.techcareer.todoapp.ITodoAppContext;
import com.techcareer.todoapp.application.forms.*;
import com.techcareer.todoapp.entities.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private ITodoAppContext __context;

    @PostMapping("/create")
    public @ResponseBody ResponseEntity<BaseResponse> CreateTodoList(@RequestParam String token,
            @RequestBody CreateTodoListForm form) {

        var request = new SecureDataRequest<CreateTodoListForm>(RequestType.POST,
                "v1.0.0", form, new SecurityToken(token));
        var response = __context.CreateTodoListEntity(request);
        if (!response.GetSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/create-item")
    public @ResponseBody ResponseEntity<BaseResponse> CreateTodoItem(@RequestParam String token,
            @RequestBody CreateTodoItemForm form) {

        var request = new SecureDataRequest<CreateTodoItemForm>(RequestType.POST, "v1.0.0", form,
                new SecurityToken(token));
        var response = this.__context.CreateTodoItem(request);
        if (!response.GetSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete-item")
    public @ResponseBody ResponseEntity<BaseResponse> DeleteTodoItem(@RequestParam String token,
            @RequestBody DataForm<Integer> form) {

        var request = new SecureDataRequest<Integer>(RequestType.DELETE, "v1.0.0", form.data(),
                new SecurityToken(token));
        var response = this.__context.DeleteTodoItemById(request);
        if (!response.GetSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<BaseResponse> DeleteTodoList(@RequestParam String token,
            @RequestBody DataForm<Integer> form) {

        var request = new SecureDataRequest<Integer>(RequestType.DELETE, "v1.0.0", form.data(),
                new SecurityToken(token));
        var response = this.__context.DeleteTodoListById(request);
        if (!response.GetSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-all")
    public @ResponseBody ResponseEntity<BaseDataResponse<List<TodoList>>> GetAllTodoLists(@RequestParam String token) {

        var request = new SecureRequest(RequestType.GET, "v1.0.0", new SecurityToken(token));
        var response = this.__context.GetAllTodoListsByToken(request);
        if (!response.GetSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<BaseResponse> UpdateTodoItem(@RequestParam String token,
            @RequestBody UpdateTodoItemForm form) {

        var request = new SecureDataRequest<UpdateTodoItemForm>(RequestType.PUT, "v1.0.0", form, new SecurityToken(token));
        var response = this.__context.UpdateTodoItemByForm(request);

        if (!response.GetSuccess()) {

            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

}
