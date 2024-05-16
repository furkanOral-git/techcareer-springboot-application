package com.techcareer.todoapp.controllers;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrfurkisan.core.application.auth.ISecurityCenter;
import com.mrfurkisan.core.contracts.abstracts.BaseResponse;
import com.mrfurkisan.core.contracts.abstracts.RequestTypesEnum;
import com.mrfurkisan.core.contracts.requests.SecureDataRequest;
import com.mrfurkisan.core.contracts.requests.SecureRequest;
import com.mrfurkisan.core.security.authentication.SecurityToken;
import com.mrfurkisan.core.security.authorization.AccessDimensionLevel;
import com.mrfurkisan.core.security.authorization.Authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Authority(AccessDimensionLevel = AccessDimensionLevel.Authenticated)
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private ISecurityCenter __securityCenter;

    @DeleteMapping("/logout")
    public @ResponseBody BaseResponse Logout(@RequestParam String token) {
        
        var secure = new SecurityToken(token);
        var request = new SecureRequest(RequestTypesEnum.DELETE, "v1.0.0", secure);
        return this.__securityCenter.Logout(request);
    }

    @PutMapping("/pass")
    public @ResponseBody BaseResponse ChangePassword(@RequestParam String token, @RequestBody String newPass) {

        var secure = new SecurityToken(token);
        var request = new SecureDataRequest<String>(RequestTypesEnum.PUT, "v1.0.0", newPass, secure);
        return this.__securityCenter.ChangePassword(request);
    }

    @PutMapping("/email")
    public @ResponseBody BaseResponse ChangeEmail(@RequestParam String token, @RequestBody String newEmail) {

        var secure = new SecurityToken(token);
        var request = new SecureDataRequest<String>(RequestTypesEnum.PUT, "v1.0.0", newEmail, secure);
        return this.__securityCenter.ChangeEmail(request);
    }

    @PutMapping("/username")
    public @ResponseBody BaseResponse ChangeUsername(@RequestParam String token, @RequestBody String newUsername) {

        var secure = new SecurityToken(token);
        var request = new SecureDataRequest<String>(RequestTypesEnum.PUT, "v1.0.0", newUsername, secure);
        return this.__securityCenter.ChangeUserName(request);
    }
}
