package com.techcareer.todoapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mrfurkisan.core.application.auth.ISecurityCenter;
import com.mrfurkisan.core.application.forms.*;
import com.mrfurkisan.core.contracts.abstracts.BaseDataResponse;
import com.mrfurkisan.core.contracts.abstracts.BaseResponse;
import com.mrfurkisan.core.contracts.abstracts.RequestType;
import com.mrfurkisan.core.contracts.requests.FreeDataRequest;
import com.mrfurkisan.core.security.authentication.SecurityToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(produces = { "application/json" })
public class AuthenticationController {

    @Autowired
    private ISecurityCenter __security;

    // HttpMessageConverter ihtiyacı var direkt olarak json nesnesi döndürülmüyor.
    @PostMapping("/api/auth")
    public @ResponseBody ResponseEntity<BaseDataResponse<SecurityToken>> Verify(@RequestBody LoginForm form) {

        var request = new FreeDataRequest<LoginForm>(RequestType.GET, "v1.0.0", form);
        var response = this.__security.Login(request);
        if (response.GetSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);

    }

    @PostMapping("/api/sign")
    public @ResponseBody ResponseEntity<BaseResponse> SignIn(@RequestBody RegisterForm form) {

        var request = new FreeDataRequest<RegisterForm>(RequestType.POST, "v1.0.0", form);
        var response = this.__security.SignIn(request);
        if (response.GetSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

}
