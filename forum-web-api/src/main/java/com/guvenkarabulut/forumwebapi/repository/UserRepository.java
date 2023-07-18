package com.guvenkarabulut.forumwebapi.repository;

import com.guvenkarabulut.forumwebapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
}
