package com.crud.card.controller;

import com.crud.card.modelo.ModelService;
import com.crud.card.modelo.UserModel;
import com.crud.card.repositorio.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepo userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserModel>> list(){
        var result = userService.AllUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/saveUser")
    public ResponseEntity<ModelService> saveUser(@RequestBody UserModel user){
        ModelService messageResp = new ModelService();
        int result = userService.saveUser(user);
        if(result == 1){
            messageResp.setMessage("User saved with success");
            messageResp.setSuccess(true);
        }
        return new ResponseEntity<>(messageResp, HttpStatus.OK);
    }

    @PutMapping("/userUpdate")
    public ResponseEntity<ModelService> updateUser(@RequestBody UserModel user){
        ModelService messageResp = new ModelService();
        int result = userService.updateUser(user);
        if(result == 1){
            messageResp.setSuccess(true);
            messageResp.setMessage("User Update with success");
        }
        return new ResponseEntity<>(messageResp,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ModelService> deleteUser(@PathVariable int id){
        ModelService messageResp = new ModelService();
        int result = userService.deleteUser(id);
        if(result==1){
            messageResp.setSuccess(true);
            messageResp.setMessage("User Delete with success");
        }
        return new ResponseEntity<>(messageResp, HttpStatus.OK);
    }
}
