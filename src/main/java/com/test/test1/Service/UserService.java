package com.test.test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.test1.Entity.UserEntity;
import com.test.test1.Exeption.UserAlreadyExsist;
import com.test.test1.Exeption.UserNotFound;
import com.test.test1.model.User;
import com.test.test1.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registrarion(UserEntity user) throws UserAlreadyExsist{
        if(userRepo.findByName(user.getName()) != null){
                throw new UserAlreadyExsist("Такой пользователь уже существует!");
            }
            return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFound{
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFound("Такого пользователя нет!");
        }
        return User.toModel(user);
    }   

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
