package com.vooban.controller;

import com.vooban.domain.City;
import com.vooban.exception.SuggestionNotFoundException;
import com.vooban.service.CityService;

import com.vooban.web.Adapters.CityAdapter;
import com.vooban.web.SuggestionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jnobert on 2016-11-23.
 */
@RestController
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/suggestions")
    public SuggestionsDTO getSuggestedCities(
            @RequestParam(name = "q") String criteria,
            @RequestParam(name = "lat", required = false) Double latitude,
            @RequestParam(name = "long", required = false) Double longitude) {
        List<City> cities = cityService.list(criteria, latitude, longitude);

        if (cities.isEmpty()) {
            throw new SuggestionNotFoundException("No city suggestions found with criteria: " + criteria);
        }

        SuggestionsDTO suggestionsDTO = new SuggestionsDTO();
        suggestionsDTO.setSuggestions(CityAdapter.toDTOList(cities));

        return suggestionsDTO;
    }

    @ExceptionHandler(SuggestionNotFoundException.class)
    public void handleSuggestionNotFound(SuggestionNotFoundException exception, HttpServletResponse response) throws IOException
    {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());

    }
}
