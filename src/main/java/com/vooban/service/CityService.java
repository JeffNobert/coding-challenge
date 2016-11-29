package com.vooban.service;

import com.vooban.domain.City;

import java.util.List;


/**
 * Created by jnobert on 2016-11-23.
 */
public interface CityService
{
    List<City> list(String criteria, Double latitude, Double longitude, int page);
}
