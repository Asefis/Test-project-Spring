package com.test.test1.Entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ToDoEntity> todos;

    public List<ToDoEntity> getTodos() {
        return todos;
    }
    public void setTodos(List<ToDoEntity> todos) {
        this.todos = todos;
    }
    public UserEntity(){
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
