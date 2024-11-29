package com.caldeira.projetofinal.user.controllers;

import com.caldeira.projetofinal.user.models.request.UserRequestModel;
import com.caldeira.projetofinal.user.models.response.UserResponseModel;
import com.caldeira.projetofinal.user.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController{
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseModel>> getAll(){
        List<UserResponseModel> allUsers= userService.getAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserResponseModel> getById(@PathVariable UUID id){
        UserResponseModel requestedUser = userService.getById(id);
        if (requestedUser == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(requestedUser, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseModel> create(@RequestBody UserRequestModel requestModel){
        try{
            UserResponseModel responseModel = userService.create(requestModel);
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseModel> update(@RequestBody UserRequestModel requestModel, @PathVariable UUID updatingID){
        try {
            UserResponseModel responseModel = userService.update(updatingID, requestModel);
            if (responseModel == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
