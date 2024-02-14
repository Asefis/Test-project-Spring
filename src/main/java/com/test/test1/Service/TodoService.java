package com.test.test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test1.Entity.ToDoEntity;
import com.test.test1.Entity.UserEntity;
import com.test.test1.model.ToDo;
import com.test.test1.repository.ToDoRepo;
import com.test.test1.repository.UserRepo;

@Service
public class TodoService {
    @Autowired
    private ToDoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public ToDo createTodo(ToDoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return ToDo.toModel(todoRepo.save(todo));
    }

    public ToDo compliteTodo(Long userId){
        ToDoEntity todo = todoRepo.findById(userId).get();
        todo.setComplited(!todo.isComplited());
        return ToDo.toModel(todoRepo.save(todo));
    }
}
