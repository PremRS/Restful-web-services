package com.prajasekaran.tutorials.restfulwebservices.repositories;

import com.prajasekaran.tutorials.restfulwebservices.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
