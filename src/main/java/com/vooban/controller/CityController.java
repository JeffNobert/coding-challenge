package com.vooban.controller;

import com.vooban.domain.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jnobert on 2016-11-23.
 */
@RestController
public class CityController
{
    @GetMapping("/suggestions")
    public List<City> getSuggestedCities(
            @RequestParam(name = "q") String criteria,
            @RequestParam(name = "lat", required = false) Double latitude,
            @RequestParam(name = "long", required = false) Double longitude)
    {
        return null;
    }


}
