package com.test.test1.model;

import java.util.List;
import java.util.stream.Collectors;

import com.test.test1.Entity.UserEntity;

public class User {

    private Long id;
    private String name;
    private List<ToDo> todos;

    public List<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setTodos(entity.getTodos().stream().map(ToDo:: toModel).collect(Collectors.toList()));
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(){
    }

    
}
