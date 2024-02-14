package com.test.test1.model;

import com.test.test1.Entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private boolean complited;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplited() {
        return complited;
    }

    public void setComplited(boolean complited) {
        this.complited = complited;
    }

    public ToDo(){

    }

    public static ToDo toModel(ToDoEntity entity){
        ToDo model = new ToDo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setComplited(entity.isComplited());
        return model;
    }

    
}
