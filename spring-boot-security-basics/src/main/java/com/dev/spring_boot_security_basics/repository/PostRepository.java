package com.dev.spring_boot_security_basics.repository;

import com.dev.spring_boot_security_basics.model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Integer> {
}
