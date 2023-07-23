package com.guvenkarabulut.forumwebapi.repository;

import com.guvenkarabulut.forumwebapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    Optional<Post> findById(int integer);

}
