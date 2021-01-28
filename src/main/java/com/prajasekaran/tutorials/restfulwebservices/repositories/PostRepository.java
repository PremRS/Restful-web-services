package com.prajasekaran.tutorials.restfulwebservices.repositories;

import com.prajasekaran.tutorials.restfulwebservices.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
