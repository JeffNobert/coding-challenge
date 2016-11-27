package com.vooban.web.Adapters;

import com.vooban.domain.City;
import com.vooban.web.CityDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jnobert on 2016-11-27.
 */
public class CityAdapter
{
    public static List<CityDTO> toDTOList(List<City> entities)
    {
        List<CityDTO> list = new ArrayList<>();

        if(CollectionUtils.isEmpty(entities))
        {
            return list;
        }

        for(City entity : entities)
        {
            list.add(toDTO(entity));
        }

        return list;
    }

    public static CityDTO toDTO (City entity)
    {
        if(entity == null)
        {
            return null;
        }

        CityDTO dto = new CityDTO();
        dto.setName(entity.getFullName());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setScore(entity.getScore());

        return dto;
    }
}
