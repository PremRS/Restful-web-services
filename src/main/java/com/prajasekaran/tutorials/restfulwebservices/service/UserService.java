package com.prajasekaran.tutorials.restfulwebservices.service;

import com.prajasekaran.tutorials.restfulwebservices.domain.User;
import com.prajasekaran.tutorials.restfulwebservices.repositories.PostRepository;
import com.prajasekaran.tutorials.restfulwebservices.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Set<User> findAll() {
        Set<User> users = new HashSet<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
