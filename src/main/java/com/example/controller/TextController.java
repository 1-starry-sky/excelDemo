package com.example.controller;

import com.example.common.entity.Result;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="test",produces =  "application/json;charset=utf-8")
public class TextController {

    @GetMapping(value = "test2")
    public Result test(){
        return new Result(1, "220");
    }
}
