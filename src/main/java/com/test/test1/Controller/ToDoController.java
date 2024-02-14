package com.test.test1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.test1.Entity.ToDoEntity;
import com.test.test1.Service.TodoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity todo, @RequestParam Long userId){
        try{
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    } 
    
    @PutMapping
    public ResponseEntity createTodo(@RequestParam Long userId){
        try{
            return ResponseEntity.ok(todoService.compliteTodo(userId));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    
}
