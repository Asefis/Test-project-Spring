package com.test.test1.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.test1.Entity.UserEntity;



public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
