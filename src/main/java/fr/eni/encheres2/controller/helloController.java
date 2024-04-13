package fr.eni.encheres2.controller;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class helloController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello bitch";
    }

}

