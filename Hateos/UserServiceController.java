package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserServiceController {

    @Autowired
    private UserDaoApplication userDaoApplication;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userDaoApplication.findAll();
    }

    @GetMapping("users/{id}")
    public EntityModel<User> specificUser(@PathVariable int id){
        User one = userDaoApplication.findOne(id);
        if(one == null){
            throw new UserNotFoundException("id :"+id);
        }

        EntityModel<User> resource = EntityModel.of(one);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).findAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;

    }

    @PostMapping("/users")
    public ResponseEntity createUsers(@RequestBody User user){
        User savedUsers = userDaoApplication.saveUsers(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUsers.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id){
        User user = userDaoApplication.deleteById(id);
        if(user == null){
            throw new UserNotFoundException("id :"+id);
        }
    }
}
