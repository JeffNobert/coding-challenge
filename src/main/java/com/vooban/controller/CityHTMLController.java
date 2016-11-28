package com.vooban.controller;

import com.vooban.domain.City;
import com.vooban.exception.SuggestionNotFoundException;
import com.vooban.service.CityService;

import com.vooban.web.Adapters.CityAdapter;
import com.vooban.web.SuggestionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

/**
 * Created by jnobert on 2016-11-237.
 */
@Controller
@RequestMapping("/cities")
public class CityHTMLController {
    private CityService cityService;

    @Autowired
    public CityHTMLController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/suggestions")
    public String getSuggestedCities(@RequestParam(name = "q") String criteria, Model model)
    {
        List<City> cities = cityService.list(criteria, null, null);

        if (cities.isEmpty()) {
            throw new SuggestionNotFoundException("No city suggestions found with criteria: " + criteria);
        }
        model.addAttribute("suggestions", cities);
        return "views/list";

    }
}
