package com.vooban.repository;

import com.vooban.domain.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jnobert on 2016-11-23.
 */
@Repository
public interface CityRepository
{

    List<City> findAllCitiesByName(String criteria);


}
