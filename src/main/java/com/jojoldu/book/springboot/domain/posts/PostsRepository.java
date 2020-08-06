package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
//public interface PostsRepository extends CrudRepository<Posts, Long> {
}
