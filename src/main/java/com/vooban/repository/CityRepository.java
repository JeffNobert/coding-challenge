package com.vooban.repository;

import com.vooban.domain.City;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jnobert on 2016-11-23.
 */
@Repository
public interface CityRepository extends CrudRepository<City, Integer>
{

    List<City> findByNameContaining(String criteria);


}
