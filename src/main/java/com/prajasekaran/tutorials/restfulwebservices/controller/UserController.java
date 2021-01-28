package com.prajasekaran.tutorials.restfulwebservices.controller;

import com.prajasekaran.tutorials.restfulwebservices.domain.User;
import com.prajasekaran.tutorials.restfulwebservices.exception.UserNotFoundException;
import com.prajasekaran.tutorials.restfulwebservices.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserService userService;
    private MessageSource messageSource;

    public UserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping("/users")
    public Set<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable Long id) {
        User fetchedUser = userService.findById(id);

        if(fetchedUser == null) {
            throw new UserNotFoundException("ID is not found");
        }

        EntityModel<User> resource =  EntityModel.of(fetchedUser);

        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkBuilder.withRel("all-users"));

        return resource;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/i18n")
    public String translatedText() {
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
