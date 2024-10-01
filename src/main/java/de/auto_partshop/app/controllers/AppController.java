package de.auto_partshop.app.controllers;

import de.auto_partshop.app.models.Movie;
import de.auto_partshop.app.service.AppService;
import de.auto_partshop.security.models.MyUsers;
import de.auto_partshop.security.service.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AppController {

    private AppService appService;
    private SecurityService securityService;

    @GetMapping("/start")
    public String start(){
        return "Hello user, this is Auto Part Shop, at first you have to sign in or sign up";
    }

    @GetMapping("/list-of-all-parts")
    public ResponseEntity<List<Movie>> getAllParts(){
        return new ResponseEntity<List<Movie>>(appService.getAllParts(), HttpStatus.OK);
    }
    @PostMapping("/new")
    public String addUser(@RequestBody MyUsers users){
        securityService.addUser(users);
        return "User is saved";
    }

    @GetMapping("/login/success")
    public String loginSuccess() {
        return "success";
    }

}
