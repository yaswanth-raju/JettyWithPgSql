package com.pgDemo1.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("himan")
    String hi(){
        return "hey hi";
    }

}
