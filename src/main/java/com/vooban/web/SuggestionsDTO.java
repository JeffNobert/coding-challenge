package com.vooban.web;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jnobert on 2016-11-27.
 */
public class SuggestionsDTO
{
    private List<CityDTO> suggestions = new ArrayList<>();

    public List<CityDTO> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<CityDTO> suggestions) {
        this.suggestions = suggestions;
    }
}
