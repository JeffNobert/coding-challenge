package com.vooban.service;

import com.vooban.domain.City;
import com.vooban.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by jnobert on 2016-11-24.
 */
@Service
public class CityServiceImpl implements CityService
{
    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    @Override
    public Iterable<City> list(String criteria, Double latitude, Double longitude)
    {
        List<City> cities = cityRepository.findByNameContaining(criteria);
        return scoreResults(cities, criteria, latitude, longitude);
    }

    private List<City> scoreResults(List<City> cities, String criteria, Double latitude, Double longitude)
    {
        List<City> rankedCities = new ArrayList<>();

        Map<Integer, Double> distances = new HashMap<>();

        boolean hasLatitude = latitude != null;
        boolean hasLongitude = longitude != null;

        longitude = (longitude != null) ? longitude : 0;
        latitude = (latitude != null) ? latitude : 0;

        for(City city : cities)
        {
            float rank = scoreNameMatch(city.getName(), criteria);
            city.setRank(rank);
            rankedCities.add(city);

            if(hasLatitude || hasLongitude)
            {
                Double cityLatitude = hasLatitude ? city.getLatitude() : 0;
                Double cityLongitude = hasLongitude ? city.getLongitude() : 0;

                distances.put(city.getId(), calculateDistance(cityLatitude, cityLongitude, latitude, longitude));
            }

        }

        if(hasLatitude || hasLongitude) {
            Double maxDistance = getMaxDistance(distances.values());

            for (City rankedCity : rankedCities) {
                float score = scoreCoordinates(distances.get(rankedCity.getId()), maxDistance);
                rankedCity.setRank(rankedCity.getRank() * score);
            }
        }

        Collections.sort(rankedCities, Collections.reverseOrder());

        return rankedCities;
    }

    private float scoreNameMatch(String name, String criteria)
    {
        float temp = (float)criteria.length() / (float)name.length() ;
        return roundScore(temp);
    }

    private float scoreCoordinates(Double distance, Double maxDistance)
    {
        float temp = (float)(distance / maxDistance);
        return 1.0f - roundScore(temp);
    }

    private Double calculateDistance(Double cityLatitude, Double cityLongitude, Double criteriaLatitude, Double criteriaLongitude)
    {
        Double latitude = Math.pow(cityLatitude - criteriaLatitude, 2);
        Double longitude = Math.pow(cityLongitude - criteriaLongitude, 2);

        Double distance = Math.sqrt(longitude + latitude);

        return distance;
    }

    private Double getMaxDistance(Collection<Double> distances)
    {
        OptionalDouble max = (distances.stream().mapToDouble(Double::doubleValue).max());
        return max.isPresent() ? max.getAsDouble() : 0;
    }

    private float roundScore(float score)
    {
        int rounded = (int)(score * 100);
        return (float)rounded / 100.0f;
    }
}
