package com.test.test1.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.test1.Entity.UserEntity;
import com.test.test1.Exeption.UserAlreadyExsist;
import com.test.test1.Exeption.UserNotFound;
import com.test.test1.Service.UserService;
import com.test.test1.repository.UserRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
       try{
            userService.registrarion(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        }catch(UserAlreadyExsist e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        } 
    }
    
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        }catch(UserNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.delete(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        } 
    }
}
