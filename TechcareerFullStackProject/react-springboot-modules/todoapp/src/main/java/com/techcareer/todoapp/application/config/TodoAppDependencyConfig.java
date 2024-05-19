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
import com.mrfurkisan.core.security.authorization.RoleEntity;
import com.mrfurkisan.core.infrastructure.persistence.concrete.*;
import com.mrfurkisan.core.infrastructure.security.*;
import com.techcareer.todoapp.ITodoAppContext;
import com.techcareer.todoapp.TodoAppContext;
import com.techcareer.todoapp.persistence.TodoItemJpaRepository;
import com.techcareer.todoapp.persistence.TodoListEntityJpaRepository;
import com.techcareer.todoapp.repositories.ITodoItemRepository;
import com.techcareer.todoapp.repositories.ITodoListEntityRepository;
import com.techcareer.todoapp.services.ITodoItemService;
import com.techcareer.todoapp.services.ITodoListService;
import com.techcareer.todoapp.services.TodoItemService;
import com.techcareer.todoapp.services.TodoListService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class TodoAppDependencyConfig implements ICanAddCoreSecurityDependency {

    @PersistenceContext
    private EntityManager __manager;

    @Bean
    @Override
    public ISecurityCenter getSecurityCenter(ITokenService tokenService, IUserService userService,
            IAuthorizationService authorization) {

        return new CoreSecurityCenter(tokenService, userService, authorization);
    }

    @Bean
    @Override
    public IAuthorizationService getAuthorizationService(IRoleRepository repo,
            @Autowired IRoleEntityRepository entityRepo) {

        var service = new AuthorizationService(entityRepo, repo);
        // ADMIN
        service.GetRoleBuilder()
                .AddAllActions()
                .SetAccessLevel(AccessLevel.Admin)
                .SetDomain(DomainName.PRESCRİPTİVE)
                .BuildRole();
        // NORMAL
        service.GetRoleBuilder()
                .AddAllActions()
                .SetAccessLevel(AccessLevel.Authenticated)
                .SetDomain(DomainName.NORMAL)
                .BuildRole();
        return service;
    }

    @Bean
    @Override
    public IRoleEntityRepository getRoleEntityRepository() {

        return new RoleEntityJpaRepository(__manager, RoleEntity.class);
    };

    @Bean
    @Override
    public ITokenService getTokenService(ITokenRepository repository) {

        return new TokenService<ITokenRepository>(repository);
    };

    @Bean
    @Override
    public IUserService getUserService(IUserRepository repository) {

        return new UserService<IUserRepository>(repository);
    };

    @Bean
    @Override
    public ITokenRepository getTokenRepository() {

        return new TokenJpaRepository(this.__manager, SecurityTokenEntity.class);
    };

    @Bean
    @Override
    public IUserRepository getUserRepository() {

        return new UserJpaRepository(this.__manager, User.class);
    };

    @Bean
    @Override
    public IRoleRepository getRoleRepository() {

        return new RoleInMemoryRepository();
    }

    @Bean
    ITodoItemRepository getTodoItemRepository() {

        return new TodoItemJpaRepository(this.__manager);
    }

    @Bean
    ITodoListEntityRepository getTodoListEntityRepository() {
        return new TodoListEntityJpaRepository(this.__manager);
    }

    @Bean
    public ITodoItemService getTodoItemService(ITodoItemRepository repo) {
        return new TodoItemService(repo);
    }

    @Bean
    public ITodoListService getTodoListService(ITodoListEntityRepository repo) {

        return new TodoListService(repo);
    }

    @Bean
    public ITodoAppContext getTodoAppContext(ITodoItemService itemSer, ITodoListService listSer, ITokenService tokSer) {
        return new TodoAppContext(itemSer, listSer, tokSer);
    }

}
