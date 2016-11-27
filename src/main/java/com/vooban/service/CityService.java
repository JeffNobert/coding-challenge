package com.vooban.service;

import com.vooban.domain.City;


/**
 * Created by jnobert on 2016-11-23.
 */
public interface CityService
{
    Iterable<City> list(String criteria, Double latitude, Double longitude);
}
