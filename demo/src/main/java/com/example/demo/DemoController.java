package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DemoController {

//    @Autowired
//    private DAO test;

    @Autowired
    private JavaAccountRepo userRepo;

    @GetMapping(path = "/printAll")
    public List<HuluRegistration> getAll() {
        return userRepo.findAll();
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity registerUser(@Valid @RequestBody HuluRegistration newUser) {
        userRepo.save(newUser);
        return new ResponseEntity<>("Register new user", HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteUser(@Valid @RequestBody HuluRegistration user) {
        userRepo.delete(user);
        return new ResponseEntity<>("Delete a user", HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateUser(@Valid @RequestBody HuluRegistration oldUser, @Valid @RequestBody HuluRegistration newUser) {
        userRepo.delete(oldUser);
        userRepo.save(newUser);
        return new ResponseEntity<>("update a user", HttpStatus.CREATED);
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/test/{name}")
//    public String myGet(@PathVariable String name) {
//        return "Lichking" + name + name;
//    }
}
