package com.vooban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jnobert on 2016-11-23.
 */
@RestController
public class CityController {

    @GetMapping("/test")
    public String test()
    {
        return "home";
    }
}
