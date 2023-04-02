package com.crud.card.controller;

import com.crud.card.modelo.ModelService;
import com.crud.card.modelo.UserModel;
import com.crud.card.repositorio.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepo userService;
    private BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserModel>> list(){
        var result = userService.AllUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/saveUser")
    public ResponseEntity<ModelService> saveUser(@RequestBody UserModel user) throws NoSuchAlgorithmException {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // genera el hash de la contraseña
        int result = userService.saveUser(user);

        ModelService messageResp = new ModelService();
        if(result == 1){
            messageResp.setMessage("User saved with success");
            messageResp.setSuccess(true);
        }

        return new ResponseEntity<>(messageResp, HttpStatus.OK);
    }

    @PutMapping("/userUpdate")
    public ResponseEntity<ModelService> updateUser(@RequestBody UserModel user) throws NoSuchAlgorithmException {
        ModelService messageResp = new ModelService();
        String hashedPassword = user.getPassword() != null ? passwordEncoder.encode(user.getPassword()) : null;
        user.setPassword(hashedPassword);
        int result = userService.updateUser(user);
        if(result == 1){
            messageResp.setSuccess(true);
            messageResp.setMessage("User Update with success");
        }
        return new ResponseEntity<>(messageResp,HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<ModelService> login(@RequestBody UserModel user){
        ModelService messageResp = new ModelService();
        UserModel foundUser = userService.findByEmail(user.getEmail());
        boolean success = foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword());
        messageResp.setMessage(success ? "User logged in with success" : "Invalid email or password");
        messageResp.setSuccess(success);
        return new ResponseEntity<>(messageResp, HttpStatus.OK);
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
