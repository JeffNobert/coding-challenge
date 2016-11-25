package com.vooban.service;

import com.vooban.domain.City;
import com.vooban.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jnobert on 2016-11-24.
 */
public class CityServiceImpl implements CityService
{
    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    @Override
    public Iterable<City> list(String criteria)
    {
        return cityRepository.findAllCitiesByName(criteria);
    }
}
