package com.prajasekaran.tutorials.restfulwebservices.bootstrap;

import com.prajasekaran.tutorials.restfulwebservices.domain.User;
import com.prajasekaran.tutorials.restfulwebservices.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = User.builder().name("John").job("Dev").age(25).build();
        userService.saveUser(user);

        User user1 = User.builder().name("Wick").job("DevOps").age(23).build();
        userService.saveUser(user1);

        User user2 = User.builder().name("Jack").job("Tester").age(28).build();
        userService.saveUser(user2);
    }
}
