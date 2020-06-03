package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostsRepository extends CrudRepository<Posts, Long> {
}
