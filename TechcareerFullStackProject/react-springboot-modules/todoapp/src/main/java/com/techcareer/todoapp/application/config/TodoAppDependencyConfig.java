package com.techcareer.todoapp.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mrfurkisan.core.application.auth.*;
import com.mrfurkisan.core.application.config.ICanAddCoreSecurityDependency;
import com.mrfurkisan.core.infrastructure.services.*;
import com.mrfurkisan.core.security.authentication.*;
import com.mrfurkisan.core.security.authorization.AccessLevel;
import com.mrfurkisan.core.security.authorization.DomainName;
import com.mrfurkisan.core.infrastructure.persistence.concrete.*;
import com.mrfurkisan.core.infrastructure.security.*;


import jakarta.persistence.EntityManager;

@Configuration
public class TodoAppDependencyConfig implements ICanAddCoreSecurityDependency {

    @Autowired
    private EntityManager __manager;

    
    @Bean
    public IAuthorizationService getAuthorizationService(@Autowired IRoleRepository repo) {

        var service = new AuthorizationService(repo);
            
            //Admin
        service.GetRoleBuilder()
            .AddAllActions()
            .SetAccessLevel(AccessLevel.Admin)
            .AddDomain(DomainName.PRESCRİPTİVE)
            .BuildRole();

            //User
        service.GetRoleBuilder()
            .AddAllActions()
            .SetAccessLevel(AccessLevel.Authenticated)
            .AddDomain(DomainName.USER);
        
        return service;
    }

    @Bean
    public ITokenService getTokenService(@Autowired ITokenRepository repository) {

        return new TokenService<ITokenRepository>(repository);
    };

    @Bean
    public IUserService getUserService(@Autowired IUserRepository repository) {

        return new UserService<IUserRepository>(repository);
    };


    @Bean
    public ITokenRepository getTokenRepository() {
        // TokenInMemoryRepository.GetRepo();
        return new TokenJpaRepository(this.__manager, SecurityTokenEntity.class);
    };

    @Bean
    public IUserRepository getUserRepository() {

        return new UserJpaRepository(this.__manager, User.class);
    };

    @Bean
    public IRoleRepository getRoleRepository() {

        return new RoleInMemoryRepository();
    }

    
    @Bean
    public ISecurityCenter getSecurityCenter(@Autowired ITokenService tokenService, @Autowired IUserService userService,
            @Autowired IAuthorizationService authorizationService) {

        return new CoreSecurityCenter(tokenService, userService, authorizationService);
    }

}
