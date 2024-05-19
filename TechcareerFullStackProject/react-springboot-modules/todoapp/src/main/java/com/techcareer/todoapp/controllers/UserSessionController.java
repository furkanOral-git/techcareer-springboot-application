package com.techcareer.todoapp.controllers;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrfurkisan.core.application.auth.ISecurityCenter;
import com.mrfurkisan.core.application.forms.DataForm;
import com.mrfurkisan.core.contracts.abstracts.BaseResponse;
import com.mrfurkisan.core.contracts.abstracts.RequestType;
import com.mrfurkisan.core.contracts.requests.SecureDataRequest;
import com.mrfurkisan.core.contracts.requests.SecureRequest;
import com.mrfurkisan.core.security.authentication.SecurityToken;
import com.mrfurkisan.core.security.authorization.Authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Authority
@RequestMapping("/api/session")
public class UserSessionController {

    @Autowired
    private ISecurityCenter __securityCenter;

    @DeleteMapping("/logout")
    public @ResponseBody ResponseEntity<BaseResponse> Logout(@RequestParam String token) {

        var secure = new SecurityToken(token);
        var request = new SecureRequest(RequestType.DELETE, "v1.0.0", secure);
        var response = this.__securityCenter.Logout(request);
        if (response.GetSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/pass")
    public @ResponseBody ResponseEntity<BaseResponse> ChangePassword(@RequestParam String token, @RequestBody DataForm<String> form) {
        
        var secure = new SecurityToken(token);
        var request = new SecureDataRequest<String>(RequestType.PUT, "v1.0.0", form.data(), secure);
        var response = this.__securityCenter.ChangePassword(request);
        if (response.GetSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/email")
    public @ResponseBody ResponseEntity<BaseResponse> ChangeEmail(@RequestParam String token, @RequestBody DataForm<String> form) {

        var secure = new SecurityToken(token);
        var request = new SecureDataRequest<String>(RequestType.PUT, "v1.0.0", form.data(), secure);
        var response = this.__securityCenter.ChangeEmail(request);
        if (response.GetSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/username")
    public @ResponseBody ResponseEntity<BaseResponse> ChangeUsername(@RequestParam String token, @RequestBody DataForm<String> form) {

        var secure = new SecurityToken(token);
        var request = new SecureDataRequest<String>(RequestType.PUT, "v1.0.0", form.data(), secure);
        var response = this.__securityCenter.ChangeUserName(request);
        if (response.GetSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
