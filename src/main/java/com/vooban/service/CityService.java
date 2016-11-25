package com.vooban.service;

import com.vooban.domain.City;

import java.util.Iterator;

/**
 * Created by jnobert on 2016-11-23.
 */
public interface CityService
{
    public Iterable<City> list(String criteria);
}
