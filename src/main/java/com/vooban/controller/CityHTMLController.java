package com.vooban.controller;

import com.vooban.domain.City;
import com.vooban.domain.SearchCriteria;
import com.vooban.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jnobert on 2016-11-23.
 */
@Controller
@RequestMapping("/cities")
public class CityHTMLController {
    private CityService cityService;

    @Autowired
    public CityHTMLController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public String getSearchPage(Model model)
    {
        model.addAttribute("suggestions", new ArrayList<>());
        return "views/list";

    }

    @PostMapping("/suggestions")
    public String getSuggestedCities(@ModelAttribute SearchCriteria criteria, Model model)
    {

        List<City> cities = cityService.list("London", null, null, 0);

        model.addAttribute("suggestions", cities);
        return "views/list";

    }
}
