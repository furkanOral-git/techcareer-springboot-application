package com.techcareer.todoapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mrfurkisan.core.application.auth.ISecurityCenter;
import com.mrfurkisan.core.application.forms.*;
import com.mrfurkisan.core.contracts.abstracts.BaseDataResponse;
import com.mrfurkisan.core.contracts.abstracts.BaseResponse;
import com.mrfurkisan.core.contracts.abstracts.RequestTypesEnum;
import com.mrfurkisan.core.contracts.requests.FreeDataRequest;
import com.mrfurkisan.core.security.authentication.SecurityToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(produces = { "application/json" })
public class AuthenticationController {

    @Autowired(required = true)
    private ISecurityCenter __security;

    // HttpMessageConverter ihtiyacı var direkt olarak json nesnesi döndürülmüyor.
    @GetMapping("/api/auth")
    public @ResponseBody BaseDataResponse<SecurityToken> Verify(@RequestBody LoginForm form) {

        var request = new FreeDataRequest<LoginForm>(RequestTypesEnum.GET, "v1", form);
        return this.__security.Verify(request);

    }
    @PostMapping("/api/sign")
    public @ResponseBody BaseResponse SignIn(@RequestBody RegisterForm form) {
        
        var request = new FreeDataRequest<RegisterForm>(RequestTypesEnum.POST, "v1", form);
        return this.__security.SignIn(request);
    }

}
