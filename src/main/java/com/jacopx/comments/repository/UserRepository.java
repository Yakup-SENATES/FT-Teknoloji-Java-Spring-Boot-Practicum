package com.jacopx.comments.repository;

import com.jacopx.comments.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
