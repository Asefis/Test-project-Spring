package com.test.test1.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.test1.Entity.ToDoEntity;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long>{
}
